package com.talent.grouptwofinalproject.models;

import java.util.Date;

import lombok.Data;

@Data
public class Quote {
	private Long id;
	private String name;
	private String fathername;
	private int age;
	private Date dob;
	private String nrc;
	private String occupation;
	private String phone;
	
	private Long addressid;
	private int residenceno;
	private String roadstreet;
	private String township;
	private String city;
	
	private Long benificiaryid;
	private String benificiaryname;
	private String benificiarynrc;
	private String relationship;
	private String benificiaryphone;
	private String benificiaryaddress;


	private double suminsured;
	private int policyterm;
	private int premiumplan;
	private double monthlypremium;
	private double yearlypremium;
	private double totalpayamount;
	
	
	
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
	public Long getBenificiaryid() {
		return benificiaryid;
	}
	public void setBenificiaryid(Long benificiaryid) {
		this.benificiaryid = benificiaryid;
	}
	public String getBenificiaryname() {
		return benificiaryname;
	}
	public void setBenificiaryname(String benificiaryname) {
		this.benificiaryname = benificiaryname;
	}
	public String getBenificiarynrc() {
		return benificiarynrc;
	}
	public void setBenificiarynrc(String benificiarynrc) {
		this.benificiarynrc = benificiarynrc;
	}
	public String getRelationship() {
		return relationship;
	}
	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}
	public String getBenificiaryphone() {
		return benificiaryphone;
	}
	public void setBenificiaryphone(String benificiaryphone) {
		this.benificiaryphone = benificiaryphone;
	}
	public String getBenificiaryaddress() {
		return benificiaryaddress;
	}
	public void setBenificiaryaddress(String benificiaryaddress) {
		this.benificiaryaddress = benificiaryaddress;
	}
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
	
	
}
