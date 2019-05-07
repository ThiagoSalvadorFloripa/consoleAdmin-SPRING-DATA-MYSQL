package com.br.salvador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.br.salvador.domain.Raffle;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Repository
public interface RaffleRepository extends JpaRepository<Raffle, Long> {

	@Transactional(readOnly=true)
	@Query(value = "SELECT obj FROM Raffle obj WHERE obj.current= 1")
	Raffle findCurrentRaffle();

}
