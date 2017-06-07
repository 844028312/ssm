package com.ssm.service;

import com.ssm.entity.User;

public interface UserService {
	public int add(User u);
	public User getByUserName(String userName);
}
