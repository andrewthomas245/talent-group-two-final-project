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
@Table(name = "benificiaries")
@SQLDelete(sql = "UPDATE benificiaries SET state = 'DELETED', deletedate= CURRENT_DATE() WHERE benificiaryid = ?", check = ResultCheckStyle.COUNT )
public class Benificiaries {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "benificiaryid")
	private Long benificiaryid;
	private String name;
	private String gender;

	private String nrc;
	private String relationship;
	private String phone;
	private String address;
	
	@Column
	@Enumerated(EnumType.STRING)
	private AccountState state;
	
	private Date deletedate;
	
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
	

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public Benificiaries() {
	}

	public Benificiaries(Long benificiaryid, String name, String gender, String nrc, String relationship, String phone,
			String address, AccountState state, Date deletedate, Quotes quotes) {
		super();
		this.benificiaryid = benificiaryid;
		this.name = name;
		this.gender = gender;
		this.nrc = nrc;
		this.relationship = relationship;
		this.phone = phone;
		this.address = address;
		this.state = state;
		this.deletedate = deletedate;
		this.quotes = quotes;
	}
}
