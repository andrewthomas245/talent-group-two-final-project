package com.talent.grouptwofinalproject.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.UserModel;

public interface UserService extends UserDetailsService 
{
	public void createUser(UserModel user);
	
	public String getLoginUserName();

	Users findByName(String name);
	
	public UserModel getUserInfo();
	
	public List<Users> findUserByEmail(String email);
}
