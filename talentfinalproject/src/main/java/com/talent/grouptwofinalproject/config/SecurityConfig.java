package com.talent.grouptwofinalproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.talent.grouptwofinalproject.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/index.xhtml", "/UserRegister.xhtml").permitAll()
				.antMatchers("/home.xhtml","/myaccount.xhtml").authenticated();

		http.formLogin().loginPage("/login.xhtml").permitAll().failureUrl("/login.xhtml?error=false");

		http.logout().logoutSuccessUrl("/index.xhtml");

		http.csrf().disable();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(new BCryptPasswordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

}
//@Autowired
//public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication().withUser("john.doe").password("{noop}1234").roles("USER").and()
//			.withUser("jane.doe").password("{noop}5678").roles("ADMIN");
//}
