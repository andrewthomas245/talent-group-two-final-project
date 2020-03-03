package com.talent.grouptwofinalproject.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.Payments;
import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.models.Payment;
import com.talent.grouptwofinalproject.models.Policy;
import com.talent.grouptwofinalproject.repositories.PaymentRepository;
import com.talent.grouptwofinalproject.repositories.PolicyRepository;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {
	
	@PersistenceContext
	EntityManager em;

	@Autowired
	public PolicyRepository policyRepository;

	@Autowired
	public PaymentRepository paymentRepository;

	@Override
	public void createPayment(Payment pay, Policy pol) {
		Date date = new Date();
		
		Payments paymentEntity= new Payments();
		paymentEntity.setPaymentamount(pay.getPaymentamount());
		paymentEntity.setPaymentdate(date);
		paymentEntity.setPaymentmethod(pay.getPaymentmethod());
		
		System.out.println(pay.getPolicyid());
		
		Policies attachedPolicy = em.find(Policies.class, pay.getPolicyid());
		double yearlypremium=pol.getYearlypremium();
		double totalpaidpremium=pol.getTotalpaidpremium();
		if (totalpaidpremium >= yearlypremium) {
			attachedPolicy.setPolicystatus("Active");
			attachedPolicy.setPolicyeffectivedate(date);
			attachedPolicy.setPolicyenddate(date);
		}
		paymentEntity.setPolicies(attachedPolicy);
		
		paymentRepository.save(paymentEntity);
		
	}

	@Override
	public Boolean checkTotalPayment(Policy pol) {
		boolean check = true;
		double totalpremium=pol.getTotalpremium();
		double totalpaidpremium=pol.getTotalpaidpremium();
		
		System.out.println("Total Paid:"+totalpaidpremium);
		System.out.println("Total:"+totalpremium);
		
		
		if (totalpaidpremium >= totalpremium) {
			check=false;
		}
		
		return check;
	}
	
	
}
