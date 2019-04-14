package com.br.salvador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.Raffle;
import com.br.salvador.repositories.RaffleRepository;
import com.br.salvador.services.exceptions.ObjectNotFoundException;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class RaffleServices {

	@Autowired
	private RaffleRepository repo;

	public Raffle findById(Long id) {
		Optional<Raffle> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Raffle.class.getName()));
	}

}
