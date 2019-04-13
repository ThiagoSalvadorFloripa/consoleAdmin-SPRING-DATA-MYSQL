package com.br.salvador;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.salvador.domain.Hash;
import com.br.salvador.domain.Played;
import com.br.salvador.domain.Raffle;
import com.br.salvador.domain.User;
import com.br.salvador.repositories.HashRepository;
import com.br.salvador.repositories.PlayedRepository;
import com.br.salvador.repositories.RaffleRepository;
import com.br.salvador.repositories.UserRepository;

@SpringBootApplication
public class ConsoleAdmServerApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repoUser;

	@Autowired
	private PlayedRepository repoPlayed;
	
	@Autowired
	private HashRepository repoHash;
	
	@Autowired
	private RaffleRepository repoRaffle;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleAdmServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		
		BigDecimal amount = new BigDecimal("2500.000");
		Raffle raffle1 = new Raffle(null,amount,123456,1 );
		
		BigDecimal amount1 = new BigDecimal("500.000");
		Raffle raffle2 = new Raffle(null,amount1,123123,0 );
		
		User user1 = new User(null, "THIANA SALVADOR", "123123", "123123", "THIAGO@GMAIL.COM", 500, "0000000000");
		User user2 = new User(null, "MARIA PRADO", "123123", "123123", "THIAGO@GMAIL.COM", 500, "0000000000");
		User user3 = new User(null, "JULIA PRADO", "123123", "123123", "THIAGO@GMAIL.COM", 500, "0000000000");
		
		Played played1 = new Played(null, "123456", 000000, user1,raffle1);
		Played played2 = new Played(null, "654321", 000000, user2,raffle2);
		
		
		Hash hash1 = new Hash(null,"A526AS555AF5FA",user1);
		Hash hash2 = new Hash(null,"B526AS555AF5FB",user2);		
		user1.setHash(hash1);
		user2.setHash(hash2);
		
		repoRaffle.saveAll(Arrays.asList(raffle1, raffle2));
		
		repoUser.saveAll(Arrays.asList(user1,user2,user3));
		repoPlayed.saveAll(Arrays.asList(played1, played2));
		repoHash.saveAll(Arrays.asList(hash1, hash2));
		
		
		
		
		
		
	}

}
