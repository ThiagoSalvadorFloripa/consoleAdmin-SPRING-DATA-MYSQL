package com.br.salvador.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 3143909135782656385L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String password;
	private String repeat_password;
	private String email;
	private Integer gold;
	private String token_facebook;

	@OneToOne(cascade = CascadeType.ALL, mappedBy="user")
	//@JsonIgnore
	private Hash hash;
	
	@OneToMany(mappedBy="user")
	private List<Played> played = new ArrayList<>();

	public User() {
	}

	public User(Long id) {
		this.id = id;
	}
	

	public User(Long id, String name, String password, String repeat_password, String email, Integer gold,
			String token_facebook) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.repeat_password = repeat_password;
		this.email = email;
		this.gold = gold;
		this.token_facebook = token_facebook;
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
	
	
	public Hash getHash() {
		return hash;
	}

	public void setHash(Hash hash) {
		this.hash = hash;
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


	public List<Played> getPlayed() {
		return played;
	}


	public void setPlayed(List<Played> played) {
		this.played = played;
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

	public String getToken_facebook() {
		return token_facebook;
	}

	public void setToken_facebook(String token_facebook) {
		this.token_facebook = token_facebook;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
