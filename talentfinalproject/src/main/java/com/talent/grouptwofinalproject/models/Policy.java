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
	private Double suminsured;
	private int policyterm;
	private int premiumplan;
	private Double monthlypremium;
	private Double yearlypremium;
	private Double totalpremium;
	private Double totalpaidpremium;

	List<Payment> PaymentList = new ArrayList<Payment>();

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

}
