package de.ans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StoredProcedureApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StoredProcedureApplication.class, args);
	}

	//Test
	@Autowired Test2Repository test2Repository;
	@Autowired Test1Repository test1Repository;
	
	@Override
	public void run(String... arg0) throws Exception {
		test2Repository.run(10);
		
		List<Test> t = test1Repository.getTestsList(10);
		for(Test te : t){
			System.out.println(te);
		}
		
	}
		
}
