package com.talent.grouptwofinalproject.services;

import com.talent.grouptwofinalproject.models.Payment;
import com.talent.grouptwofinalproject.models.Policy;

public interface PaymentService {
	public void createPayment(Payment pay, Policy pol);
	
	public Boolean checkTotalPayment(Policy pol);

}
