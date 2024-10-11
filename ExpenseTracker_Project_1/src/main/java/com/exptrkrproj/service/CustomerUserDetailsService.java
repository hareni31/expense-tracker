package com.exptrkrproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exptrkrproj.model.User;
import com.exptrkrproj.repository.UserRepository;
import com.exptrkrproj.security.CustomerDetails;

@Service
public class CustomerUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found...!");
		}
		return new CustomerDetails(user);
	}

}
