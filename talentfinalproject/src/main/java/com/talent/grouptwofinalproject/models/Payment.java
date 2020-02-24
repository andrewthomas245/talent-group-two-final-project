package com.talent.grouptwofinalproject.models;

import java.util.Date;

public class Payment {
	
	private Long paymentid;
	private Long policyid;
	private Date paymentdate;
	private double paymentamount;
	
	public Long getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(Long paymentid) {
		this.paymentid = paymentid;
	}
	public Long getPolicyid() {
		return policyid;
	}
	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
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
	
	

}
