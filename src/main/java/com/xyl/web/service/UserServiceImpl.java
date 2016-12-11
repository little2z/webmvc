package com.xyl.web.service;

import com.xyl.web.entity.User;

public class UserServiceImpl implements UserService {

	public User queryUser(String username) {
		
		User user = new User();
		user.setUsername(username);
		user.setAge(18);
		return user;
	}

}
