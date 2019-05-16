package com.br.salvador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.UserLogin;
import com.br.salvador.repositories.UserLoginRepository;
/** 
 * @author kamal berriga
 *
 */
@Service
public class UserLoginService {

	@Autowired
	UserLoginRepository userRepository;

	public UserLogin save(UserLogin user) {
		return userRepository.saveAndFlush(user);
	}

	public UserLogin update(UserLogin user) {
		return userRepository.save(user);
	}

	public UserLogin find(String userName) {
		return userRepository.findOneByUsername(userName);
	}

	public Optional<UserLogin> find(Long id) {
		return userRepository.findById(id);
	}
}
