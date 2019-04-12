package com.br.salvador.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@RestController
@RequestMapping(value="/user")
public class UserResources {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "Rest funn fun";
	}
	
}
