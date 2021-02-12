package com.nextgate.assesment.datatypes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;


@Entity
@Table(name="Album")
public class Album {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=("album_id"))
	private Integer albumId;
	
//	@NotNull
//	@Column(name=("singer"))
//	private String singer;
	
	@NotNull
	@Column(name=("name"))
	private String name;

	@NotNull
	@Column(name=("year"))
	private String year;
	
	@NotNull
	@Column(name=("company"))
	private String company;
	
	private String singer;
	
	
	public Album() {
		
	}
	
public Album(String name, String singer, String year, String company) {
		this.name = name;
		this.singer = singer;
		this.year = year;
		this.company = company;
	}
	

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public Integer getAlbumId() {
		return albumId;
	}

	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
