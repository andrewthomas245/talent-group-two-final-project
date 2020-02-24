package com.talent.grouptwofinalproject.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "quotes")
public class Quotes {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long quoteid;
	private String name;
	private String fathername;
	private int age;
	private Date dob;
	private String nrc;
	private String occupation;
	private String phone;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "addressid")
    private Addresses addresses;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "benificiary_id", referencedColumnName = "benificiaryid")
    private Benificiaries benificiaries;
    
	@OneToOne(mappedBy = "quotes")
    private Policies policies;

	private double suminsured;
	private int policyterm;
	private int premiumplan;
	private double monthlypremium;
	private double yearlypremium;
	private double totalpayamount;

	//@ManyToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name = "user_id", nullable = false)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	//private Users user;

	public Long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(Long quoteid) {
		this.quoteid = quoteid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Addresses getAddresses() {
		return addresses;
	}

	public void setAddresses(Addresses addresses) {
		this.addresses = addresses;
	}

	public Benificiaries getBenificiaries() {
		return benificiaries;
	}

	public void setBenificiaries(Benificiaries benificiaries) {
		this.benificiaries = benificiaries;
	}

	//public Users getUser() {
	//	return user;
	//}

	//public void setUser(Users user) {
	//	this.user = user;
	//}

	public double getSuminsured() {
		return suminsured;
	}

	public void setSuminsured(double suminsured) {
		this.suminsured = suminsured;
	}

	public int getPolicyterm() {
		return policyterm;
	}

	public void setPolicyterm(int policyterm) {
		this.policyterm = policyterm;
	}

	public int getPremiumplan() {
		return premiumplan;
	}

	public void setPremiumplan(int premiumplan) {
		this.premiumplan = premiumplan;
	}

	public double getMonthlypremium() {
		return monthlypremium;
	}

	public void setMonthlypremium(double monthlypremium) {
		this.monthlypremium = monthlypremium;
	}

	public double getYearlypremium() {
		return yearlypremium;
	}

	public void setYearlypremium(double yearlypremium) {
		this.yearlypremium = yearlypremium;
	}

	public double getTotalpayamount() {
		return totalpayamount;
	}

	public void setTotalpayamount(double totalpayamount) {
		this.totalpayamount = totalpayamount;
	}
	
	public Policies getPolicies() {
		return policies;
	}

	public void setPolicies(Policies policies) {
		this.policies = policies;
	}

	public Quotes() {

	}

	public Quotes(Long quoteid, String name, String fathername, int age, Date dob, String nrc, String occupation,
			String phone, Addresses addresses, Benificiaries benificiaries, Policies policies, double suminsured,
			int policyterm, int premiumplan, double monthlypremium, double yearlypremium, double totalpayamount) {
		this.quoteid = quoteid;
		this.name = name;
		this.fathername = fathername;
		this.age = age;
		this.dob = dob;
		this.nrc = nrc;
		this.occupation = occupation;
		this.phone = phone;
		this.addresses = addresses;
		this.benificiaries = benificiaries;
		this.policies = policies;
		this.suminsured = suminsured;
		this.policyterm = policyterm;
		this.premiumplan = premiumplan;
		this.monthlypremium = monthlypremium;
		this.yearlypremium = yearlypremium;
		this.totalpayamount = totalpayamount;
	}
	
	

	

}
