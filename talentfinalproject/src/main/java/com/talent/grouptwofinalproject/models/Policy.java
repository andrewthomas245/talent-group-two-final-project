package com.talent.grouptwofinalproject.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Policy {
	private long id;
	private Date effectivedate;
	private Date enddate;
	private String policystatus;

	private double firstpaymentamount;

	private long quoteid;
	private String quotename;
	private String quotenrc;
	private String benificiaryname;
	private String benificiarynrc;
	private Double suminsured;
	private int policyterm;
	private int premiumplan;
	private Double monthlypremium;
	private Double quarterlypremium;
	private Double halfyearpremium;
	private Double yearlypremium;
	private Double totalpremium;
	private Double totalpaidpremium;

	List<Payment> PaymentList = new ArrayList<Payment>();
	
	private Claim claim;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getEffectivedate() {
		return effectivedate;
	}

	public void setEffectivedate(Date effectivedate) {
		this.effectivedate = effectivedate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getPolicystatus() {
		return policystatus;
	}

	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}

	public double getFirstpaymentamount() {
		return firstpaymentamount;
	}

	public void setFirstpaymentamount(double firstpaymentamount) {
		this.firstpaymentamount = firstpaymentamount;
	}

	public long getQuoteid() {
		return quoteid;
	}

	public void setQuoteid(long quoteid) {
		this.quoteid = quoteid;
	}	

	public String getQuotename() {
		return quotename;
	}

	public void setQuotename(String quotename) {
		this.quotename = quotename;
	}

	public String getQuotenrc() {
		return quotenrc;
	}

	public void setQuotenrc(String quotenrc) {
		this.quotenrc = quotenrc;
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

	public Double getSuminsured() {
		return suminsured;
	}

	public void setSuminsured(Double suminsured) {
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

	public Double getMonthlypremium() {
		return monthlypremium;
	}

	public void setMonthlypremium(Double monthlypremium) {
		this.monthlypremium = monthlypremium;
	}

	public Double getQuarterlypremium() {
		return quarterlypremium;
	}

	public void setQuarterlypremium(Double quarterlypremium) {
		this.quarterlypremium = quarterlypremium;
	}

	public Double getHalfyearpremium() {
		return halfyearpremium;
	}

	public void setHalfyearpremium(Double halfyearpremium) {
		this.halfyearpremium = halfyearpremium;
	}

	public Double getYearlypremium() {
		return yearlypremium;
	}

	public void setYearlypremium(Double yearlypremium) {
		this.yearlypremium = yearlypremium;
	}

	public Double getTotalpremium() {
		return totalpremium;
	}

	public void setTotalpremium(Double totalpremium) {
		this.totalpremium = totalpremium;
	}

	public Double getTotalpaidpremium() {
		return totalpaidpremium;
	}

	public void setTotalpaidpremium(Double totalpaidpremium) {
		this.totalpaidpremium = totalpaidpremium;
	}

	public List<Payment> getPaymentList() {
		return PaymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		PaymentList = paymentList;
	}

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}
