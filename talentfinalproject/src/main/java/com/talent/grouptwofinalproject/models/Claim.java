package com.talent.grouptwofinalproject.models;

import java.util.Date;

public class Claim {
	private Long claimid;
	private Date claimdate;
	private String claimreason;
	private Date reviewdate;
	private Date paymentdate;
	private Long policyid;
	private String claimsign;
	
	public Long getClaimid() {
		return claimid;
	}
	public void setClaimid(Long claimid) {
		this.claimid = claimid;
	}
	public Date getClaimdate() {
		return claimdate;
	}
	public void setClaimdate(Date claimdate) {
		this.claimdate = claimdate;
	}
	public String getClaimreason() {
		return claimreason;
	}
	public void setClaimreason(String claimreason) {
		this.claimreason = claimreason;
	}
	public Date getReviewdate() {
		return reviewdate;
	}
	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}
	public Date getPaymentdate() {
		return paymentdate;
	}
	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}
	public Long getPolicyid() {
		return policyid;
	}
	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
	}
	public String getClaimsign() {
		return claimsign;
	}
	public void setClaimsign(String claimsign) {
		this.claimsign = claimsign;
	}
	
}
