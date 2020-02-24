package com.talent.grouptwofinalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "addresses")
public class Addresses {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "addressid")
	private Long addressid;
	private int residenceno;

	private String roadstreet;
	private String township;
	private String city;
	
	@OneToOne(mappedBy = "addresses")
    private Quotes quotes;

	public Long getAddressid() {
		return addressid;
	}

	public void setAddressid(Long addressid) {
		this.addressid = addressid;
	}

	public int getResidenceno() {
		return residenceno;
	}

	public void setResidenceno(int residenceno) {
		this.residenceno = residenceno;
	}

	public String getRoadstreet() {
		return roadstreet;
	}

	public void setRoadstreet(String roadstreet) {
		this.roadstreet = roadstreet;
	}

	public String getTownship() {
		return township;
	}

	public void setTownship(String township) {
		this.township = township;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;
	}
	
	
	public Addresses() {
	}

	public Addresses(Long addressid, int residenceno, String roadstreet, String township, String city, Quotes quotes) {
		this.addressid = addressid;
		this.residenceno = residenceno;
		this.roadstreet = roadstreet;
		this.township = township;
		this.city = city;
		this.quotes = quotes;
	}
}
