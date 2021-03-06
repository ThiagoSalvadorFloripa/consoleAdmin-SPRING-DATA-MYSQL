package com.br.salvador.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Entity
public class Hash implements Serializable {

	private static final long serialVersionUID = -2402665727250276418L;

	@Id
	private Long id;
	private String identified;
		
	@OneToOne
	@JoinColumn(name="user_id")
	@MapsId
	@JsonIgnore
	private User user;

	public Hash() {
	}

	public Hash(Long id) {
		this.id = id;
	}
	
	public Hash(Long id, String identified, User user) {
		super();
		this.id = id;
		this.identified = identified;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentified() {
		return identified;
	}

	public void setIdentified(String identified) {
		this.identified = identified;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		Hash other = (Hash) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
