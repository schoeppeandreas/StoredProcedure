package de.ans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoredProcedureApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StoredProcedureApplication.class, args);
	}

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
