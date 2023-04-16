package com.project.springboot.app.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clients")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(name = "name_client") // If the "name" in data base is called "name_client" we need indicate it @Colum
	@NotEmpty
	private String name;
	@NotEmpty
	private String surname;
	@NotEmpty
	private String email;
	
	@Column(name ="create_at")
	@Temporal(TemporalType.DATE) // Format that saves create_at in database
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	private Date createAt;
	
	private static final long serialVersionUID = 1L;
	
	@PrePersist // Its called before insert item into Database
	public void prePersist() {
		this.createAt = new Date();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
	    return "Client [id=" + id + ", name=" + name + ", surname=" + surname + ", email=" + email + ", createAt="
	            + createAt + "]";
	}

	
	
}
