package com.talent.grouptwofinalproject.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;


@Entity
@Table(name = "addresses")
@SQLDelete(sql = "UPDATE addresses SET state = 'DELETED', deletedate= CURRENT_DATE() WHERE addressid = ?", check = ResultCheckStyle.COUNT )
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
	
	@Column
	@Enumerated(EnumType.STRING)
	private AccountState state;
	
	private Date deletedate;

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
	
	public AccountState getState() {
		return state;
	}

	public void setState(AccountState state) {
		this.state = state;
	}

	public Date getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}

	public Addresses() {
	}

	public Addresses(Long addressid, int residenceno, String roadstreet, String township, String city, Quotes quotes,
			AccountState state, Date deletedate) {
		super();
		this.addressid = addressid;
		this.residenceno = residenceno;
		this.roadstreet = roadstreet;
		this.township = township;
		this.city = city;
		this.quotes = quotes;
		this.state = state;
		this.deletedate = deletedate;
	}
	
}
