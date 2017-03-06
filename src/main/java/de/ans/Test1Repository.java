package de.ans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Test1Repository {

//	https://docs.spring.io/spring/docs/current/spring-framework-reference/html/jdbc.html
	
	private SimpleJdbcCall testReadAllTests;

	@Autowired
	public void setDataSource(JdbcTemplate jdbcTemplate) {
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		this.testReadAllTests = new SimpleJdbcCall(jdbcTemplate)
				.withProcedureName("test3")
				.returningResultSet("testRs", 
				BeanPropertyRowMapper.newInstance(Test.class));
	}
	
    @SuppressWarnings("unchecked")
    @Transactional
	public List<Test> getTestsList(Integer a_len) {
        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("a_len", a_len);
        Map<?, ?> m = testReadAllTests.execute(parameters);
        return (List<Test>) m.get("testRs");
    }

}
