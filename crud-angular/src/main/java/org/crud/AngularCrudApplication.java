package org.crud;

import org.crud.entities.User;
import org.crud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AngularCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AngularCrudApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.save(new User("ibn hicham","Mohamed","mohamed@gmail.com"));
		userRepository.save(new User("bourziza","Rabie","rabie@gmail.com"));
		userRepository.save(new User("AAZZA","Samah","samah@gmail.com"));

		
		
	}

}
