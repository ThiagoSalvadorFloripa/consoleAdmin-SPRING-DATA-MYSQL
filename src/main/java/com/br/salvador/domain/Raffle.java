package com.br.salvador.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

@Entity
public class Raffle implements Serializable {

	private static final long serialVersionUID = -4748553310628098394L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal amount;
	private String number;
	private Integer current;

	@OneToMany(mappedBy = "raffle")
	@JsonIgnore
	private List<Played> played = new ArrayList<>();

	public Raffle() {
	}

	public Raffle(Long id) {
		this.id = id;
	}

	public Raffle(Long id, BigDecimal amount, String number, Integer current) {
		super();
		this.id = id;
		this.amount = amount;
		this.number = number;
		this.current = current;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getCurrent() {
		return current;
	}

	public void setCurrent(Integer current) {
		this.current = current;
	}

	public List<Played> getPlayed() {
		return played;
	}

	public void setPlayed(List<Played> played) {
		this.played = played;
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
		Raffle other = (Raffle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
