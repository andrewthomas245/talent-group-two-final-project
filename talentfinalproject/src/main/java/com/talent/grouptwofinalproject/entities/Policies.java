package com.talent.grouptwofinalproject.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "policies")
public class Policies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyid;
	private Date policyeffectivedate;
	private Date policyenddate;
	private String policystatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quote_id", referencedColumnName = "quoteid", unique = true)
	@NotNull
	private Quotes quotes;
	
	@OneToMany(mappedBy = "policies", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Payments> payments;
	
	@OneToOne(mappedBy = "policies")
    private Claims claims;

	public Long getPolicyid() {
		return policyid;
	}

	public void setPolicyid(Long policyid) {
		this.policyid = policyid;
	}

	public Date getPolicyeffectivedate() {
		return policyeffectivedate;
	}

	public void setPolicyeffectivedate(Date policyeffectivedate) {
		this.policyeffectivedate = policyeffectivedate;
	}

	public Date getPolicyenddate() {
		return policyenddate;
	}

	public void setPolicyenddate(Date policyenddate) {
		this.policyenddate = policyenddate;
	}

	public String getPolicystatus() {
		return policystatus;
	}

	public void setPolicystatus(String policystatus) {
		this.policystatus = policystatus;
	}

	public Quotes getQuotes() {
		return quotes;
	}

	public void setQuotes(Quotes quotes) {
		this.quotes = quotes;
	}

	public List<Payments> getPayments() {
		return payments;
	}

	public void setPayments(List<Payments> payments) {
		this.payments = payments;
	}
	
	
}
