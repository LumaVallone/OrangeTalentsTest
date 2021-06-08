package com.orangetalents3.orangetalents3.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message = "A propriedade 'name' é obrigatória")
	private String name;
	
	@NotNull(message = "A propriedade 'email' é obrigatória")
	@Column(nullable = false, unique = true)
	private String email;
	
	@NotNull(message = "A propriedade 'cpf' é obrigatória")
	@Column(nullable = false, unique = true)
	private String cpf;
	
	@NotNull(message = "A propriedade 'birthday' é obrigatória")
	@Column(nullable = false)
	private Date birthday;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf= cpf;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
