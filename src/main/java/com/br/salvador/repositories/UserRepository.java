package com.br.salvador.repositories;

import org.springframework.stereotype.Repository;

import com.br.salvador.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
