package com.br.salvador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.Raffle;
import com.br.salvador.repositories.RaffleRepository;
import com.br.salvador.services.exceptions.DataIntegrityException;
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
	
	public Raffle insert(Raffle obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Raffle update(Raffle obj) {
		this.findById(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw  new DataIntegrityException("It is not possible to delete a draw because a linked play already exists");
		}
		
	}
	public List<Raffle> findAll() {
		return repo.findAll();
	}
	
	public Page<Raffle> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	

}
