package de.ans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;

@Repository
public class Test2Repository {
//	private JdbcTemplate jdbcTemplate;
	private Test2_SP sproc;

	@Autowired
	public void setDataSource(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
		this.sproc = new Test2_SP(jdbcTemplate.getDataSource());
	}

	/* * wraps stored procedure call */
	@Transactional //(readOnly = true)
	public void run(int a_len) {
		sproc.execute(a_len);
		//return (String) sproc.execute(a_len);
	}

	/* * Inner class to implement stored procedure in spring. */
	private class Test2_SP extends StoredProcedure {
		private static final String SPROC_NAME = "test2";

		public Test2_SP(DataSource datasource) {
			super(datasource, SPROC_NAME);
			declareParameter(new SqlParameter("a_len", Types.INTEGER));
			declareParameter(new SqlOutParameter("s_artikel", Types.VARCHAR));
			declareParameter(new SqlOutParameter("i_bestellmenge", Types.INTEGER));
			declareParameter(new SqlOutParameter("s_beschreibung", Types.VARCHAR));
			declareParameter(new SqlOutParameter("i_kalendertage_bis_lieferung", Types.INTEGER));
			compile();
		}

		public void execute(int a_len) {			
			Map<String, Object> results = super.execute(a_len);
			System.out.println(results.get("s_artikel"));
			System.out.println(results.get("i_bestellmenge"));
			System.out.println(results.get("s_beschreibung"));
			System.out.println(results.get("i_kalendertage_bis_lieferung"));
			//return results.get("name");
		}
	}
}
