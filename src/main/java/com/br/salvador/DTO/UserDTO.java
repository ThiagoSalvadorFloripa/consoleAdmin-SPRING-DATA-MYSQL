package com.br.salvador.DTO;
/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

import java.io.Serializable;

import com.br.salvador.domain.User;

public class UserDTO implements Serializable {

	private static final long serialVersionUID = 2732031770286791302L;
	
	private Long id;
	private String name;
	private String email;
	private Integer gold;
	
	public UserDTO () {}
	
	public UserDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		this.gold = user.getGold();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}
	
	

}
