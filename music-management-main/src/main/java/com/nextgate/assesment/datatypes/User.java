package com.nextgate.assesment.datatypes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=("user_id"))
	private long id;
	
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	public User(String username) {
		this.username = username;
	}
	
	public User() {
	}

	public User(long id, String username) {
		this.id = id;
		this.username = username;
	}
	
	public User(String username, String password) {
		this.password = password;
		this.username = username;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
