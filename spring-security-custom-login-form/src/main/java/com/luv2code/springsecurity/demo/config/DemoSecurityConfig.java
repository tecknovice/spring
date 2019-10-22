package com.luv2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//add users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication()
		.withUser(users.username("John").password("pass").roles("USER","MANAGER"))
		.withUser(users.username("Mary").password("pass").roles("USER","MANAGER","ADMIN"))
		.withUser(users.username("Jessica").password("pass").roles("USER"));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.anyRequest().authenticated()
				.antMatchers("/").hasRole("USER")
				.antMatchers("/manager/**").hasRole("MANAGER")
				.antMatchers("/admin/**").hasRole("ADMIN")
			.and()
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
				.logout()
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}

}
