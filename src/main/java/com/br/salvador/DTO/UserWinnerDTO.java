package com.br.salvador.DTO;
/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.br.salvador.domain.Played;

public class UserWinnerDTO implements Serializable {

	private static final long serialVersionUID = -8339845891754853512L;
	
	private String id;
	private String name;
	private String numberPlayed;
	private String numberRaffle;
	private String current;
	private String time;
	private BigDecimal amount;
	private Integer limit;

	public UserWinnerDTO(Played played) {
		super();
		this.id = String.valueOf(new Long(played.getUser().getId()));
		this.name = played.getUser().getName();
		this.numberPlayed = played.getNumber();
		this.numberRaffle = Integer.toString(played.getRaffle().getNumber());
		this.current = Integer.toString(played.getRaffle().getCurrent());
		this.time = Integer.toString(played.getTime());
		this.amount = played.getRaffle().getAmount();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumberPlayed() {
		return numberPlayed;
	}

	public void setNumberPlayed(String numberPlayed) {
		this.numberPlayed = numberPlayed;
	}

	public String getNumberRaffle() {
		return numberRaffle;
	}

	public void setNumberRaffle(String numberRaffle) {
		this.numberRaffle = numberRaffle;
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	
	
	
	





}
