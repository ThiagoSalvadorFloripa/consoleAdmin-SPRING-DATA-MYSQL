package com.br.salvador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.User;
import com.br.salvador.repositories.UserRepository;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public User getUserById(Long id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
