package com.br.salvador.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.salvador.domain.Raffle;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Repository
public interface RaffleRepository extends JpaRepository<Raffle, Long> {

}
