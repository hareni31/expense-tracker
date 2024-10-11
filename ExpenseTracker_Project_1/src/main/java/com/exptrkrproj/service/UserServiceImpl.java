package com.exptrkrproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.exptrkrproj.model.User;
import com.exptrkrproj.repository.UserRepository;
import com.exptrkrproj.security.CustomerDetails;

@Service
public class UserServiceImpl implements UserService,UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		//Encode the password before saving
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		// Save the user in the repository
		 userRepository.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User Not Found...!!");
		}
		 return new CustomerDetails(user);
	}

}
