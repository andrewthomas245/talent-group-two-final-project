package com.talent.grouptwofinalproject.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.UserModel;
import com.talent.grouptwofinalproject.repositories.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void createUser(UserModel user) {
		
		Users userEntity = new Users();
		
		userEntity.setName(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		
		userRepository.save(userEntity);
	}

}
