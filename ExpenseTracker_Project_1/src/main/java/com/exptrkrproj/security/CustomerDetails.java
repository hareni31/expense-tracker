package com.exptrkrproj.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.exptrkrproj.model.User;

public class CustomerDetails  implements UserDetails{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final User user;
	
	

	
	public CustomerDetails(User user) {
		
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;//this method return the authorities (usually roles) assigned to the user
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();//returns the user's password which stored in user entity
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();//returns the user's name which stored in user entity
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
		
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
		
	}
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
		
	}
	@Override
	public boolean isEnabled()
	{
		return true;
		
	}
	public User getUser() {
		return user;//allowing access to the actual user entity if  needed elsewhere in the application not a part of userdetails interface
		
	}

}
