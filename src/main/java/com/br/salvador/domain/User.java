package com.br.salvador.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 3143909135782656385L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	private String repeat_password;
	private String email;
	private Integer gold;
	private BigInteger token_facebook;
	private String hash;
	
	
	
	public User() {
	}
	
	public User ( Long id, String name, String password, String repeat_password, String email, Integer gold, BigInteger token_facebook, String hash) {
		super();
		this.id = id; this.name = name; this.password = password; this.repeat_password = repeat_password;
		this.email = email; this.gold = gold; this.token_facebook = token_facebook; this.hash = hash;
	}
	
	public User (Long id){
		this.id= id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeat_password() {
		return repeat_password;
	}

	public void setRepeat_password(String repeat_password) {
		this.repeat_password = repeat_password;
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

	public BigInteger getToken_facebook() {
		return token_facebook;
	}

	public void setToken_facebook(BigInteger token_facebook) {
		this.token_facebook = token_facebook;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}


















