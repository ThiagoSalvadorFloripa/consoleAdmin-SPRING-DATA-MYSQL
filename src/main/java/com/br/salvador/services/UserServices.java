package com.br.salvador.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.salvador.domain.User;
import com.br.salvador.repositories.UserRepository;
import com.br.salvador.services.exceptions.DataIntegrityException;
import com.br.salvador.services.exceptions.ObjectNotFoundException;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Service
public class UserServices {
	
	@Autowired
	private UserRepository repo;
	
	public User findById(Long id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
	}
	
	public User insert(User obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public User update(User obj) {
		this.findById(obj.getId());
		return repo.save(obj);
	}
	
	public void deleteById(Long id) {
		this.findById(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw  new DataIntegrityException("Não é possível deletar um usuário que já tem uma jogada ou hash");
		}
		
	}
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public Page<User> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		//PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		PageRequest pageRequest =PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}























