package com.talent.grouptwofinalproject.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.Policies;
import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.UserModel;
import com.talent.grouptwofinalproject.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService 
{

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void createUser(UserModel user) {

		Users userEntity = new Users();

		userEntity.setName(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(userEntity);
	}
	
	@Override
    public String getLoginUserName() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println(authentication.getName());
    	return authentication.getName();
     }

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Users user = userRepository.findByName(name);
		if(user==null)
			throw new UsernameNotFoundException("User 404");
		return new UserPrincipal(user);
	}

	@Override
	public Users findByName(String name) {
		
		return userRepository.findByName(name);
	}

	@Override
	public UserModel getUserInfo() {
		String name = getLoginUserName();
		Users user=userRepository.findByName(name);
		
		UserModel myaccount= new UserModel();
		myaccount.setUsername(user.getName());
		myaccount.setEmail(user.getEmail());
		System.out.println(myaccount);
		return myaccount;
	}

	@Override
	public Users findUserByEmail(String email) {
		System.out.println("Finding: "+ email);
		Users entity = userRepository.findByEmail(email);
		System.out.println(entity.getEmail());
		return entity;
	}
	
}
