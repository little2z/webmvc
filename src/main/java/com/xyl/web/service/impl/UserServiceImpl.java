package com.xyl.web.service.impl;

import com.xyl.web.entity.User;
import com.xyl.web.service.UserService;

public class UserServiceImpl implements UserService {

	public User queryUser(String username) {
		
		User user = new User();
		user.setAge(50);
		return user;
	}
	
}
