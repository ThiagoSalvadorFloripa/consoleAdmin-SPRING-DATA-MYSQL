package com.br.salvador.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.salvador.domain.Hash;
import com.br.salvador.domain.User;
import com.br.salvador.services.HashServices;
import com.br.salvador.services.UserServices;
/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@RestController
@RequestMapping(value="/hash")
public class HashResources {
	
	@Autowired
	private HashServices s;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Hash> find(@PathVariable Long id){
		Hash obj = s.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
}














