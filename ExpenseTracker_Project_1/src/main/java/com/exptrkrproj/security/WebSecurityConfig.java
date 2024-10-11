package com.exptrkrproj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.exptrkrproj.service.CustomerUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
@Autowired
private CustomerUserDetailsService customUserDetailsService;
@Bean
public static PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	
}
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception
{
	http
	.csrf(csrf->csrf.disable())
	.authorizeHttpRequests(requests->requests
	.requestMatchers("/css/**","/js/**","/images/**","/style.css").permitAll()
	.requestMatchers("/","/login","/register").permitAll()
	.anyRequest().authenticated()
	)
	.formLogin(login->login
			.loginPage("/login")
			.defaultSuccessUrl("/dashboard", true)
			.permitAll()
			)
	.logout(logout->logout
			
			.logoutSuccessUrl("/login?logout")
			);
	
	return http.build();
}
	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth)throws Exception{
	
    auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
}
}
