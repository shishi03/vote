package com.yc.vote.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.vote.entity.User;
import com.yc.vote.mapper.UserMapper;
import com.yc.vote.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	
	public User login(User user) {
		
		return userMapper.getUserByUser(user);
	}


	public void register(User user) {
		
	}

}
