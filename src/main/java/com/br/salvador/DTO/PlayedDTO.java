package com.br.salvador.DTO;

import java.io.Serializable;

import com.br.salvador.domain.Played;

/**
 * @author Thiago Salvador - thiago.salvadorpower@gmail.com
 */
public class PlayedDTO implements Serializable {

	private static final long serialVersionUID = -6449282273167154496L;

	private Long id;
	private String number;
	private Integer time;
	private String user_name;
	private Long user_id;
	private Integer raffle_number;

	public PlayedDTO() {
	}

	public PlayedDTO(Played played) {
		this.id = played.getId();
		this.number = played.getNumber();
		this.time = played.getTime();
		this.user_id = played.getUser().getId();
		this.user_name = played.getUser().getName();
		this.raffle_number = played.getRaffle().getNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getRaffle_number() {
		return raffle_number;
	}

	public void setRaffle_number(Integer raffle_number) {
		this.raffle_number = raffle_number;
	}

}
