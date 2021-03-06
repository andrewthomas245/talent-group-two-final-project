package com.talent.grouptwofinalproject.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.Claims;
import com.talent.grouptwofinalproject.entities.Payments;
import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.entities.Quotes;
import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.Claim;
import com.talent.grouptwofinalproject.models.Payment;
import com.talent.grouptwofinalproject.models.Policy;
import com.talent.grouptwofinalproject.models.Quote;
import com.talent.grouptwofinalproject.repositories.*;

@Service
@Transactional
public class PolicyServiceImpl implements PolicyService {

	@PersistenceContext
	EntityManager em;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public UserService userService;

	@Autowired
	public PolicyRepository policyRepository;

	@Autowired
	public QuoteRepository quoteRepository;

	@Autowired
	public PaymentRepository paymentRepository;

	@Autowired
	public ClaimRepository claimRepository;

	@Override
	public void createPolicy(Policy pol) {
		Policies policyEntity = new Policies();

		policyEntity.setPolicyeffectivedate(pol.getEffectivedate());
		policyEntity.setPolicyenddate(pol.getEnddate());
		policyEntity.setPolicystatus("Pending");

		Quotes attachedQuote = em.find(Quotes.class, pol.getQuoteid());
		policyEntity.setQuotes(attachedQuote);

		Date date = new Date();

		Payments paymentEntity = new Payments();
		paymentEntity.setPaymentamount(pol.getFirstpaymentamount());
		paymentEntity.setPaymentmethod(pol.getPaymentmethod());
		paymentEntity.setPaymentdate(date);
		paymentEntity.setPolicies(policyEntity);
		
		String policystatus = policyEntity.getPolicystatus();

		int policyterm = pol.getPolicyterm();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, policyterm);
		Date enddate = cal.getTime();

		double yearlypremium = pol.getYearlypremium();
		double totalpaidpremium = pol.getFirstpaymentamount();

		System.out.println("Yearly: " + yearlypremium);
		System.out.println("Total Paid: " + totalpaidpremium);

		if (totalpaidpremium >= yearlypremium && policystatus.equals("Pending")) {
			policyEntity.setPolicystatus("Active");
			policyEntity.setPolicyeffectivedate(date);
			policyEntity.setPolicyenddate(enddate);
		}

		policyRepository.save(policyEntity);
		paymentRepository.save(paymentEntity);
	}

	@Override
	public List<Policy> getPolicies(Policy pol) {
		List<Policy> modellist = new ArrayList<Policy>();
		List<Policies> entitylist = new ArrayList<Policies>();

		Users u = userRepository.findByName(userService.getLoginUserName());
		Long id = u.getUserid();

		entitylist = policyRepository.findByUser(id);

		System.out.println("find all " + entitylist);
		for (Policies p : entitylist) {
			Policy model = new Policy();

			model.setId(p.getPolicyid());
			model.setPolicystatus(p.getPolicystatus());
			model.setQuotename(p.getQuotes().getName());
			model.setPolicyterm(p.getQuotes().getPolicyterm());
			model.setPremiumplan(p.getQuotes().getPremiumplan());

			modellist.add(model);

		}
		return modellist;
	}

	@Override
	public Policy getQuoteAndPaymentById(Long id) {
		List<Payment> modellist = new ArrayList<Payment>();
		List<Policies> entitylist = new ArrayList<Policies>();
		List<Quotes> entitylist2 = new ArrayList<Quotes>();
		List<Payments> entitylist3 = new ArrayList<Payments>();
		List<Claims> entitylist4 = new ArrayList<Claims>();

		double totalpaidpremium = 0;

		Policy model1 = new Policy();

		entitylist = policyRepository.getDetailByID(id);

		for (Policies p : entitylist) {
			model1.setId(p.getPolicyid());
			model1.setPolicystatus(p.getPolicystatus());
			model1.setQuoteid(p.getQuotes().getQuoteid());
			model1.setEffectivedate(p.getPolicyeffectivedate());
			model1.setEnddate(p.getPolicyenddate());
		}

		entitylist2 = quoteRepository.getQuoteDetailByID(model1.getQuoteid());

		for (Quotes q : entitylist2) {
			model1.setQuoteid(q.getQuoteid());
			model1.setQuotename(q.getName());
			model1.setQuotenrc(q.getNrc());
			model1.setBenificiaryname(q.getBenificiaries().getName());
			model1.setBenificiarynrc(q.getBenificiaries().getNrc());
			model1.setPolicyterm(q.getPolicyterm());
			model1.setPremiumplan(q.getPremiumplan());
			model1.setMonthlypremium(q.getMonthlypremium());
			model1.setQuarterlypremium(q.getQuarterlypremium());
			model1.setHalfyearpremium(q.getHalfyearpremium());
			model1.setYearlypremium(q.getYearlypremium());
			model1.setTotalpremium(q.getTotalpayamount());
		}

		entitylist3 = paymentRepository.findDetail(id);

		for (Payments p : entitylist3) {
			Payment model2 = new Payment();
			model2.setPaymentamount(p.getPaymentamount());
			model2.setPaymentdate(p.getPaymentdate());
			model2.setPaymentmethod(p.getPaymentmethod());
			totalpaidpremium = totalpaidpremium + p.getPaymentamount();
			System.out.println(totalpaidpremium);
			modellist.add(model2);
		}

		entitylist4 = claimRepository.getClaimByPolicy(id);

		if (!entitylist4.isEmpty()) {

			Claim model3 = new Claim();

			for (Claims c : entitylist4) {
				model3.setClaimdate(c.getClaimdate());
				model3.setClaimreason(c.getClaimreason());
				model3.setClaimsign(c.getClaimsign());

				System.out.println(c.getClaimsign());
			}

			model1.setClaim(model3);

		}

		model1.setTotalpaidpremium(totalpaidpremium);

		model1.setPaymentList(modellist);

		System.out.println(model1.getClaim());

		// modellist.add(model1);

		return model1;

	}

	@Override
	public List<Policies> findQuoteInPolicy(Long id) {
		System.out.println("Finding: " + id);
		List<Policies> entitylist = policyRepository.getPolicyByQuote(id);
		System.out.println(entitylist);
		return entitylist;
	}

	@Override
	public Boolean checkYearlyPayment(Policy pol) {
		boolean check = true;
		double yearlypremium = pol.getYearlypremium();
		double totalpaidpremium = pol.getTotalpaidpremium();
		if (totalpaidpremium >= yearlypremium) {
			check = false;
		}
		return check;
	}

	@Override
	public String checkStatus(Policy pol) {
		String check = pol.getPolicystatus();
		System.out.println(pol.getPolicystatus());
		return check;
	}

	@Override
	public Policy getQuoteData(Policy pol, Quote quo) {
		pol.setQuoteid(quo.getId());
		pol.setQuotename(quo.getName());
		pol.setQuotenrc(quo.getNrc());
		pol.setPremiumplan(quo.getPremiumplan());
		int premiumplan = quo.getPremiumplan();
		pol.setPolicyterm(quo.getPolicyterm());
		pol.setMonthlypremium(quo.getMonthlypremium());
		pol.setQuarterlypremium(quo.getQuarterlypremium());
		pol.setHalfyearpremium(quo.getHalfyearpremium());
		pol.setYearlypremium(quo.getYearlypremium());

		if (premiumplan == 1) {
			pol.setFirstpaymentamount(quo.getMonthlypremium());
		} else if (premiumplan == 3) {
			pol.setFirstpaymentamount(quo.getQuarterlypremium());
		} else if (premiumplan == 6) {
			pol.setFirstpaymentamount(quo.getHalfyearpremium());
		} else {
			pol.setFirstpaymentamount(quo.getYearlypremium());
		}

		return pol;
	}

}
