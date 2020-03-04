package com.talent.grouptwofinalproject.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;

import com.talent.grouptwofinalproject.entities.Users;
import com.talent.grouptwofinalproject.models.UserModel;
import com.talent.grouptwofinalproject.services.UserService;

@Named
@ViewScoped
public class UserController {

	private UserModel user = new UserModel();
	
	private UserModel viewuser = new UserModel();

	private boolean skip;

	@Autowired
	UserService userService;

	public String save() {

		Users FindUser = userService.findByName(user.getUsername());
		List<Users> FindUserByMail = userService.findUserByEmail(user.getEmail());
		if (FindUser != null) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail", "The Username: "
					+ user.getUsername() + " has already been taken. Try again with a new user name."));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} else if (!FindUserByMail.isEmpty()) {
			System.out.println("DUPLICATE");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage("Error", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fail",
					"The Email: " + user.getEmail() + " has already been registered. Try again with a new email."));
			context.getExternalContext().getFlash().setKeepMessages(true);

		} else {
			System.out.println("Here");
			userService.createUser(user);

			FacesMessage msg = new FacesMessage("Successful",
					"Username: " + user.getUsername() + " is created successfully.");

			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, msg);
			context.getExternalContext().getFlash().setKeepMessages(true);

			user = new UserModel();

			return "/userlogin.xhtml?faces-redirect=true";
		}
		return null;

	}

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("hello world, I have just started up");
	}

	@EventListener
	public void doSomething(InteractiveAuthenticationSuccessEvent event) {
		System.out.println("hello world, I have just logged in");
	}

	public void fetchUser() {
		System.out.println("Here");
		viewuser = userService.getUserInfo();
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public UserModel getViewuser() {
		return viewuser;
	}

	public void setViewuser(UserModel viewuser) {
		this.viewuser = viewuser;
	}

}
