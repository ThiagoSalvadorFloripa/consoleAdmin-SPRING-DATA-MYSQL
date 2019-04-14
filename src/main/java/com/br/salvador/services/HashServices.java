package com.br.salvador.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.Hash;
import com.br.salvador.repositories.HashRepository;
import com.br.salvador.services.exceptions.ObjectNotFoundException;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class HashServices {

	@Autowired
	private HashRepository repo;

	public Hash getHashdById(Long id) {
		Optional<Hash> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Hash.class.getName()));
	}

}
