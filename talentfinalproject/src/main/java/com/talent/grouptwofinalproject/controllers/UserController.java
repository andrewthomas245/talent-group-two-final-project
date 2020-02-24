package com.talent.grouptwofinalproject.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.talent.grouptwofinalproject.models.UserModel;
import com.talent.grouptwofinalproject.services.UserService;

@Named
@ViewScoped
public class UserController {
	
    private UserModel user = new UserModel();
     
    private boolean skip;
    
    public UserModel getUser() {
        return user;
    }
 
    public void setUser(UserModel user) {
        this.user = user;
    }
    @Autowired
    UserService userService;
    
    public void save() {
    	System.out.println("Here");
    	userService.createUser(user);
        FacesMessage msg = new FacesMessage("Successful", "Welcome :" + user.getUsername());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
}
