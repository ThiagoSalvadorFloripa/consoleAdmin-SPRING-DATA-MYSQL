package com.br.salvador.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.salvador.domain.Played;
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

}
