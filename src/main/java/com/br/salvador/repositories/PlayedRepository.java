package com.br.salvador.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.salvador.domain.Played;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Repository
public interface PlayedRepository extends JpaRepository<Played, Long> {
	
	@Transactional(readOnly=true)
	@Query(value = "SELECT obj FROM Played obj INNER JOIN User u ON obj.user = u.id WHERE u.name LIKE :name%")
	List<Played> findUserByName(@Param("name")String name);
	
	@Transactional(readOnly=true)
	@Query(value = "SELECT obj FROM Played obj INNER JOIN User u ON obj.user = u.id WHERE u.id = :id")
	List<Played> findUserById(@Param("id")Long id);
	
}


