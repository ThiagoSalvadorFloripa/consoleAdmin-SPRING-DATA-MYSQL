package com.br.salvador.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.br.salvador.DTO.PlayedDTO;
import com.br.salvador.DTO.UserDTO;
import com.br.salvador.domain.Played;
import com.br.salvador.domain.User;
import com.br.salvador.services.PlayedServices;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@RestController
@RequestMapping(value = "/played")
public class PlayedResources {

	@Autowired
	private PlayedServices s;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Played> find(@PathVariable Long id) {
		Played obj = s.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Played obj) {
		obj = s.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Played obj, @PathVariable Long id) {
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
	public ResponseEntity<List<Played>> findAll() {
		List<Played> list = s.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public ResponseEntity<Page<PlayedDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "user_name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		
		Page<Played> list = s.findPage(page, linesPerPage, orderBy, direction);
		Page<PlayedDTO> listDto = list.map(obj -> new PlayedDTO(obj)); //convert a type list for other list
		return ResponseEntity.ok().body(listDto);
		//for test http://localhost:8080/Played/page?linesPerPage=3&page=1
	}
	
	@RequestMapping("/findByName/{name}")
	public ResponseEntity<List<PlayedDTO>> findUserByName(@PathVariable("name") String name) {
		List<Played> list = s.findUserByName(name.toUpperCase());
		List<PlayedDTO> listDto = list.stream().map(obj -> new PlayedDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping("/findById/{id}")
	public ResponseEntity<List<PlayedDTO>> findUserById(@PathVariable("id") Long id) {
		List<Played> list = s.findUserById(id);
		List<PlayedDTO> listDto = list.stream().map(obj -> new PlayedDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
}
