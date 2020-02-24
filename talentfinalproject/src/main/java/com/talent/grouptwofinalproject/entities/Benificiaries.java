package com.talent.grouptwofinalproject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "benificiaries")
public class Benificiaries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "benificiaryid")
	private Long benificiaryid;
	private String name;

	private String nrc;
	private String relationship;
	private String phone;
	private String address;
	
	@OneToOne(mappedBy = "benificiaries")
    private Quotes quotes;

	public Long getBenificiaryid() {
		return benificiaryid;
	}

	public void setBenificiaryid(Long benificiaryid) {
		this.benificiaryid = benificiaryid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;
	}

	public Benificiaries() {
	}

	public Benificiaries(Long benificiaryid, String name, String nrc, String relationship, String phone, String address,
			Quotes quotes) {
		this.benificiaryid = benificiaryid;
		this.name = name;
		this.nrc = nrc;
		this.relationship = relationship;
		this.phone = phone;
		this.address = address;
		this.quotes = quotes;
	}

	

}
