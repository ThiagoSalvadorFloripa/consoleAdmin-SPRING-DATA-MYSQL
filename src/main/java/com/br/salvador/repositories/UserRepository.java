package com.br.salvador.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.salvador.DTO.UserDTO;
import com.br.salvador.DTO.UserWinnerDTO;
import com.br.salvador.domain.User;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Transactional(readOnly=true)
	User findByEmail(String email);
	
	@Transactional(readOnly=true)
	@Query(value = "SELECT obj FROM User obj WHERE obj.name LIKE :name%")
	List<User> findUserByName(@Param("name") String name);
	
	 
	
}
