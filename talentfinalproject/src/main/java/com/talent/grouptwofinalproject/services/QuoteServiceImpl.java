package com.talent.grouptwofinalproject.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.AccountState;
import com.talent.grouptwofinalproject.entities.Addresses;
import com.talent.grouptwofinalproject.entities.Benificiaries;
import com.talent.grouptwofinalproject.entities.Quotes;
import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.*;
import com.talent.grouptwofinalproject.repositories.AddressRepository;
import com.talent.grouptwofinalproject.repositories.BeneficiaryRepository;
import com.talent.grouptwofinalproject.repositories.QuoteRepository;
import com.talent.grouptwofinalproject.repositories.UserRepository;

@Service
@Transactional
public class QuoteServiceImpl implements QuoteService {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	public UserRepository userRepository;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public QuoteRepository quoteRepository;

	@Autowired
	public AddressRepository addressRepository;

	@Autowired
	public BeneficiaryRepository benificiaryRepository;

	@Override
	public void createQuote(Quote quo) {
		AccountState state= AccountState.ACTIVE;
		
		Addresses addressesEntity = new Addresses();

		addressesEntity.setResidenceno(quo.getResidenceno());
		addressesEntity.setRoadstreet(quo.getRoadstreet());
		addressesEntity.setTownship(quo.getTownship());
		addressesEntity.setCity(quo.getCity());
		addressesEntity.setState(state);

		// addressRepository.save(addressesEntity);

		Benificiaries benificiariesEntity = new Benificiaries();

		benificiariesEntity.setName(quo.getBenificiaryname());
		benificiariesEntity.setPhone(quo.getBenificiaryphone());
		benificiariesEntity.setNrc(quo.getBenificiarynrc());
		benificiariesEntity.setRelationship(quo.getRelationship());
		benificiariesEntity.setAddress(quo.getBenificiaryaddress());
		benificiariesEntity.setPhone(quo.getBenificiaryphone());
		benificiariesEntity.setState(state);

		// benificiaryRepository.save(benificiariesEntity);

		Quotes quotesEntity = new Quotes();

		quotesEntity.setName(quo.getName());
		quotesEntity.setFathername(quo.getFathername());
		quotesEntity.setAge(quo.getAge());
		quotesEntity.setDob(quo.getDob());
		quotesEntity.setNrc(quo.getNrc());
		quotesEntity.setOccupation(quo.getOccupation());
		quotesEntity.setPhone(quo.getPhone());

		quotesEntity.setPolicyterm(quo.getPolicyterm());
		quotesEntity.setPremiumplan(quo.getPremiumplan());
		quotesEntity.setSuminsured(quo.getSuminsured());
		quotesEntity.setMonthlypremium(quo.getMonthlypremium());
		quotesEntity.setYearlypremium(quo.getYearlypremium());
		quotesEntity.setTotalpayamount(quo.getTotalpayamount());
		quotesEntity.setState(state);
		
		quotesEntity.setAddresses(addressesEntity);
		quotesEntity.setBenificiaries(benificiariesEntity);
		
		Users u=userRepository.findByName(quo.getUsername());
		quotesEntity.setUsers(u);

		quoteRepository.save(quotesEntity);

	}

	@Override
	public List<Quote> getQuotes(Quote quo) {
		List<Quote> modellist = new ArrayList<Quote>();
		List<Quotes> entitylist = new ArrayList<Quotes>();
		
		Users u=userRepository.findByName(userService.getLoginUserName());
		Long id=u.getUserid();

		entitylist = quoteRepository.getQuoteByUserID(id);
		
		System.out.println("find all " + entitylist);
		for (Quotes q : entitylist) {
			Quote model = new Quote();

			model.setId(q.getQuoteid());
			model.setName(q.getName());
			model.setSuminsured(q.getSuminsured());
			model.setPolicyterm(q.getPolicyterm());

			modellist.add(model);

		}
		return modellist;

	}

	@Override
	public Quote getQuoteDetailById(Long id) {
		List<Quote> modellist = new ArrayList<Quote>();
		List<Quotes> entitylist = new ArrayList<Quotes>();
		List<Addresses> entitylist2 = new ArrayList<Addresses>();
		List<Benificiaries> entitylist3 = new ArrayList<Benificiaries>();

		Quote model = new Quote();

		entitylist = quoteRepository.getQuoteDetailByID(id);

		for (Quotes q : entitylist) {
			model.setId(q.getQuoteid());
			model.setName(q.getName());
			model.setGender(q.getGender());
			model.setFathername(q.getFathername());
			model.setAge(q.getAge());
			model.setDob(q.getDob());
			model.setNrc(q.getNrc());
			model.setPhone(q.getPhone());
			model.setOccupation(q.getOccupation());

			model.setSuminsured(q.getSuminsured());
			model.setPremiumplan(q.getPremiumplan());
			model.setPolicyterm(q.getPolicyterm());
			model.setMonthlypremium(q.getMonthlypremium());
			model.setYearlypremium(q.getYearlypremium());
			model.setTotalpayamount(q.getTotalpayamount());
		}

		entitylist2 = addressRepository.getAddressByID(id);

		for (Addresses a : entitylist2) {
			model.setAddressid(a.getAddressid());
			model.setResidenceno(a.getResidenceno());
			model.setRoadstreet(a.getRoadstreet());
			model.setTownship(a.getTownship());
			model.setCity(a.getCity());
		}

		entitylist3 = benificiaryRepository.getBenificiaryByID(id);

		for (Benificiaries b : entitylist3) {
			model.setBenificiaryid(b.getBenificiaryid());
			model.setBenificiaryname(b.getName());
			model.setBenificiarygender(b.getGender());
			model.setBenificiarynrc(b.getNrc());
			model.setRelationship(b.getRelationship());
			model.setBenificiaryaddress(b.getAddress());
			model.setBenificiaryphone(b.getPhone());
		}

		modellist.add(model);

		return model;

	}

	@Override
	public Quote calculate(Quote quo) {
		int age = quo.getAge();
		int policyterm = quo.getPolicyterm();
		double suminsured = quo.getSuminsured();
		double yearlypremium = 0;

		if (policyterm == 5) {
			if (age >= 10 && age <= 27) {
				yearlypremium = suminsured * 0.190800;
			} else if (age >= 28 && age <= 39) {
				yearlypremium = suminsured * 0.192000;
			} else if (age >= 40 && age <= 44) {
				yearlypremium = suminsured * 0.193200;
			} else if (age >= 45 && age <= 47) {
				yearlypremium = suminsured * 0.194400;
			} else if (age >= 48 && age <= 50) {
				yearlypremium = suminsured * 0.195600;
			} else if (age == 51 || age == 52) {
				yearlypremium = suminsured * 0.196800;
			} else if (age == 53 || age == 54) {
				yearlypremium = suminsured * 0.198000;
			} else if (age == 55) {
				yearlypremium = suminsured * 0.199200;
			} else if (age == 56) {
				yearlypremium = suminsured * 0.200400;
			} else if (age == 57) {
				yearlypremium = suminsured * 0.201600;
			} else if (age == 58) {
				yearlypremium = suminsured * 0.202800;
			} else if (age == 59) {
				yearlypremium = suminsured * 0.204000;
			} else if (age == 60) {
				yearlypremium = suminsured * 0.205200;
			}
		}

		if (policyterm == 7) {
			if (age >= 10 && age <= 32) {
				yearlypremium = suminsured * 0.130800;
			} else if (age >= 33 && age <= 40) {
				yearlypremium = suminsured * 0.132000;
			} else if (age >= 41 && age <= 44) {
				yearlypremium = suminsured * 0.133200;
			} else if (age >= 45 && age <= 47) {
				yearlypremium = suminsured * 0.134400;
			} else if (age == 48 || age == 49) {
				yearlypremium = suminsured * 0.135600;
			} else if (age == 50 || age == 51) {
				yearlypremium = suminsured * 0.136800;
			} else if (age == 52 || age == 53) {
				yearlypremium = suminsured * 0.138000;
			} else if (age == 54) {
				yearlypremium = suminsured * 0.139200;
			} else if (age == 55) {
				yearlypremium = suminsured * 0.140400;
			} else if (age == 56 || age == 57) {
				yearlypremium = suminsured * 0.141600;
			} else if (age == 58) {
				yearlypremium = suminsured * 0.144000;
			}
		}
		if (policyterm == 10) {
			if (age >= 10 && age <= 34) {
				yearlypremium = suminsured * 0.086400;
			} else if (age >= 35 && age <= 40) {
				yearlypremium = suminsured * 0.087600;
			} else if (age >= 41 && age <= 44) {
				yearlypremium = suminsured * 0.088800;
			} else if (age == 45 || age == 46) {
				yearlypremium = suminsured * 0.090000;
			} else if (age == 47 || age == 48) {
				yearlypremium = suminsured * 0.091200;
			} else if (age == 49 || age == 50) {
				yearlypremium = suminsured * 0.092400;
			} else if (age == 51 || age == 52) {
				yearlypremium = suminsured * 0.093600;
			} else if (age == 53) {
				yearlypremium = suminsured * 0.094800;
			} else if (age == 54) {
				yearlypremium = suminsured * 0.096000;
			} else if (age == 55) {
				yearlypremium = suminsured * 0.097200;
			}
		}

		double monthlypremium = yearlypremium / 12;
		double totalpayamount = yearlypremium * policyterm;

		quo.setMonthlypremium(monthlypremium);
		quo.setYearlypremium(yearlypremium);
		quo.setTotalpayamount(totalpayamount);

		return quo;
	}

	@Override
	public void updateQuote(Quote quo) {
		Optional<Quotes> quotesDb = this.quoteRepository.findById(quo.getId());
		Optional<Addresses> addressesDb = this.addressRepository.findById(quo.getId());
		Optional<Benificiaries> benificariesDb = this.benificiaryRepository.findById(quo.getId());

		Addresses addressesUpdate = addressesDb.get();
		addressesUpdate.setResidenceno(quo.getResidenceno());
		addressesUpdate.setRoadstreet(quo.getRoadstreet());
		addressesUpdate.setTownship(quo.getTownship());
		addressesUpdate.setCity(quo.getCity());

		Benificiaries benificiariesUpdate = benificariesDb.get();
		benificiariesUpdate.setName(quo.getBenificiaryname());
		benificiariesUpdate.setNrc(quo.getBenificiarynrc());
		benificiariesUpdate.setRelationship(quo.getRelationship());
		benificiariesUpdate.setAddress(quo.getBenificiaryaddress());
		benificiariesUpdate.setPhone(quo.getBenificiaryphone());
		benificiariesUpdate.setGender(quo.getBenificiarygender());

		Quotes quotesUpdate = quotesDb.get();
		quotesUpdate.setName(quo.getName());
		quotesUpdate.setFathername(quo.getFathername());
		quotesUpdate.setAge(quo.getAge());
		quotesUpdate.setDob(quo.getDob());
		quotesUpdate.setNrc(quo.getNrc());
		quotesUpdate.setOccupation(quo.getOccupation());
		quotesUpdate.setGender(quo.getGender());

		quotesUpdate.setPolicyterm(quo.getPolicyterm());
		quotesUpdate.setPremiumplan(quo.getPremiumplan());
		quotesUpdate.setSuminsured(quo.getSuminsured());
		quotesUpdate.setMonthlypremium(quo.getMonthlypremium());
		quotesUpdate.setYearlypremium(quo.getYearlypremium());
		quotesUpdate.setTotalpayamount(quo.getTotalpayamount());
		
		quotesUpdate.setAddresses(addressesUpdate);
		quotesUpdate.setBenificiaries(benificiariesUpdate);

		quoteRepository.save(quotesUpdate);

	}

	@Override
	public void deleteQuote(Long id) {
		Addresses a= em.find(Addresses.class,id);
		addressRepository.delete(a);
		
		Benificiaries b= em.find(Benificiaries.class,id);
		benificiaryRepository.delete(b);
		
		Quotes q= em.find(Quotes.class,id);
		quoteRepository.delete(q);
		
	}
	
	

}
