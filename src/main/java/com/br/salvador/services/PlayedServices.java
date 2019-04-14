package com.br.salvador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.Played;
import com.br.salvador.repositories.PlayedRepository;
import com.br.salvador.services.exceptions.ObjectNotFoundException;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class PlayedServices {

	@Autowired
	private PlayedRepository repo;

	public Played getPlayedById(Long id) {
		Optional<Played> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Played.class.getName()));
	}

}
