package com.talent.grouptwofinalproject.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userid;
	private String name;

	//@OneToMany(mappedBy = "users", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//private List<Quotes> quotes;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//public List<Quotes> getQuotes() {
	//	return quotes;
	//}

	//public void setQuotes(List<Quotes> quotes) {
	//	this.quotes = quotes;
	//}

	public Users() {
	}

	public Users(Long userid, String name) {
		this.userid = userid;
		this.name = name;
	}

	//public Users(Long userid, String name, List<Quotes> quotes) {
	//	this.userid = userid;
	//	this.name = name;
	//	this.quotes = quotes;
	//}
	
	


}
