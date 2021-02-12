package com.nextgate.assesment.datatypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Singer")
public class Singer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=("singer_Id"))
	private Integer singer_Id;
	
	@NotNull
	@Column(name=("name"))
	private String name;

	@NotNull
	@Column(name=("dob"))
	private String dob;
	
	@NotNull
	@Column(name=("gender"))
	private String gender;
	
	@NotNull
	@Column(name=("company"))
	private String company;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="singer_fk", referencedColumnName = "singer_Id")
	private List<Album> albums = new ArrayList<Album>();
	
	
	public Singer() {
		
	}
	
	
	public Singer(String name, LocalDate dob, String gender, String company) {
		this.name = name;
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
		this.dob = dob.format(myFormatObj);
		this.gender = gender;
		this.company = company;
	}
	
	
	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSingerId() {
		return singer_Id;
	}
	
	public void setSingerId(Integer singerId) {
		this.singer_Id = singerId;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(LocalDate dob) {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		this.dob = dob.format(myFormatObj);
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	

}
