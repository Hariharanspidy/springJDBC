package com.hari.springJDBCDemo;

import com.hari.springJDBCDemo.model.Alien;
import com.hari.springJDBCDemo.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {

		ApplicationContext context=SpringApplication.run(SpringJdbcDemoApplication.class, args);
		Alien a1=context.getBean(Alien.class);
		a1.setName("Hari");
		a1.setId(1);
		a1.setTech("Java");

		AlienRepo repo=context.getBean(AlienRepo.class);
		repo.save(a1);
		System.out.println(repo.findall());
    }

}
