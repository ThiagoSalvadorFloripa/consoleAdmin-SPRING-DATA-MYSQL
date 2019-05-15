package com.br.salvador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.salvador.DTO.UserWinnerDTO;
import com.br.salvador.domain.Played;
import com.br.salvador.repositories.PlayedRepository;
import com.br.salvador.services.exceptions.DataIntegrityException;
import com.br.salvador.services.exceptions.ObjectNotFoundException;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class PlayedServices {

	@Autowired
	private PlayedRepository repo;

	public Played findById(Long id) {
		Optional<Played> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Played.class.getName()));
	}
	
	public Played insert(Played obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Played update(Played obj) {
		this.findById(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw  new DataIntegrityException("Can not delete a move because a linked user already exists");
		}
		
	}
	public List<Played> findAll() {
		return repo.findAll();
	}
	
	public Page<Played> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public List<Played> findUserByName(String name) {
		return repo.findUserByName(name);
	}

	public List<Played> findUserById(Long id) {
		return repo.findUserById(id);
	}

	public List<Played> getWinnerByLimit(int limit) {
		return repo.getWinnerByLimit(limit);
	}

}
