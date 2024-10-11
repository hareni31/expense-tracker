package com.exptrkrproj.service;

import com.exptrkrproj.model.User;

public interface UserService {
	void save(User user);
	User findByUsername(String username);

}
