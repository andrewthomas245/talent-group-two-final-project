package com.talent.grouptwofinalproject.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "payments")
public class Payments {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long paymentid;
	private Date paymentdate;
	private double paymentamount;
	private String paymentmethod;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "policy_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Policies policies;
	
	public Long getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	
	public double getPaymentamount() {
		return paymentamount;
	}
	public void setPaymentamount(double paymentamount) {
		this.paymentamount = paymentamount;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public Policies getPolicies() {
		return policies;
	}
	public void setPolicies(Policies policies) {
		this.policies = policies;
	}
	
	
}
