package com.br.salvador;

import java.math.BigInteger;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.salvador.domain.User;
import com.br.salvador.repositories.UserRepository;

@SpringBootApplication
public class ConsoleAdmServerApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsoleAdmServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		User user1 = new User(null,"THIANA SALVADOR", "123123", "123123", "THIAGO@GMAIL.COM", 500, "dfg87df878df7g87df87d9f8g", "@@@@@@@dfg87f87d9f8g");
		User user2 = new User(null,"THiAGO SALVADOR", "123123", "123123", "THIAGO@GMAIL.COM", 500, "dfg87df878df7g87df87d9f8g", "@@@@@@@dfg87f87d9f8g");
		User user3 = new User(null,"TAINA SALVADOR", "123123", "123123", "THIAGO@GMAIL.COM", 500, "dfg87df878df7g87df87d9f8g", "@@@@@@@dfg87f87d9f8g");
		User user4 = new User(null,"VICTOR MACHADO", "123123", "123123", "THIAGO@GMAIL.COM", 500, "dfg87df878df7g87df87d9f8g", "@@@@@@@dfg87f87d9f8g");
		
		repo.saveAll(Arrays.asList(user1,user2,user3,user4));
		
		
	}

}
