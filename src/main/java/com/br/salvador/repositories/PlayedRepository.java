package com.br.salvador.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Pageable;
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
	
	
	@Query(value = "SELECT p FROM Played  as p INNER JOIN Raffle r on p.raffle = r.id INNER JOIN User  u on p.user = u.id where r.current = 1 and r.number = p.number")
	List<Played> getWinnerByLimit(String name, Pageable pageable);
	
	
	
	
	
	
}

/*
 * SELECT u.id, u.name, p.number,  r.number,  r.current, p.time, r.amount FROM PLAYED  as p INNER JOIN RAFFLE r on p.raffle_id = r.id INNER JOIN USER  u on p.user_id = u.id where r.current = 1 and r.number = p.number
 */

