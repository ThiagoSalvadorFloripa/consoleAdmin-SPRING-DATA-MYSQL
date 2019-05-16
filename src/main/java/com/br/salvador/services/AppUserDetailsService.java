package com.br.salvador.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.UserLogin;


/**
 * This Service class for providing the user credentials from the database.
 * 
 * @author kamal berriga
 *
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserLoginService userLoginService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLogin user = userLoginService.find(username);
		return  user;
	}

}
