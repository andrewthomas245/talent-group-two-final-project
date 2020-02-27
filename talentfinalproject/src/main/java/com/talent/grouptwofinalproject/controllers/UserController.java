package com.talent.grouptwofinalproject.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

import com.talent.grouptwofinalproject.models.UserModel;
import com.talent.grouptwofinalproject.services.UserService;

@Named
@ViewScoped
public class UserController {
	
    private UserModel user = new UserModel();
    
    private boolean skip;
    
	@Autowired
    UserService userService;
    
    public void save() {
    	
    	System.out.println("Here");
    	userService.createUser(user);
    	
		FacesMessage msg = new FacesMessage("Successful",
				"User with Name: " + user.getUsername() + " is created successfully.");

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, msg);
		context.getExternalContext().getFlash().setKeepMessages(true);
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
     
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
    
    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
    }

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
    
    
    

}
