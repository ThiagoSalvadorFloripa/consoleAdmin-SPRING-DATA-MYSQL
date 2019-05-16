package com.br.salvador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.salvador.domain.UserLogin;

@Repository
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

public UserLogin findOneByUsername(String username);
}
