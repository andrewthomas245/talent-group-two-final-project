package com.talent.grouptwofinalproject.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "claims")
public class Claims {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long claimid;
	private Date claimdate;
	private String claimreason;
	private Date reviewdate;
	private Date paymentdate;
	
	@Lob
	@Column( length = 100000 )
	private String claimsign;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id", referencedColumnName = "policyid", unique = true)
	@NotNull
	private Policies policies;
	
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
	public Policies getPolicies() {
		return policies;
	}
	public void setPolicies(Policies policies) {
		this.policies = policies;
	}
	public String getClaimsign() {
		return claimsign;
	}
	public void setClaimsign(String claimsign) {
		this.claimsign = claimsign;
	}
	
}
