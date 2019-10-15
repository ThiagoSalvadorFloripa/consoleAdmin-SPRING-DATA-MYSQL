package com.br.salvador.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.salvador.domain.Raffle;
import com.br.salvador.services.RaffleServices;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@RestController
@RequestMapping(value = "/raffle")
public class RaffleResources {

	@Autowired
	private RaffleServices s;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Raffle> find(@PathVariable Long id) {
		Raffle obj = s.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Raffle obj) {
		obj = s.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Raffle obj, @PathVariable Long id) {
		obj.setId(id);
		obj = s.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		s.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Raffle>> findAll() {
		List<Raffle> list = s.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<Raffle>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "current") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		
		Page<Raffle> list = s.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
		//for test http://localhost:8080/Raffle/page?linesPerPage=3&page=1
	}
	
	@RequestMapping(value = "/current",method = RequestMethod.GET)
	public ResponseEntity<Raffle> findCurrent() {
		Raffle obj = s.findCurrent();
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/random",method = RequestMethod.GET)
	public ResponseEntity<Integer> sortRandomNumber() {
		int obj = s.sortRandomNumber();
		return ResponseEntity.ok().body(obj);
	}
	

}
