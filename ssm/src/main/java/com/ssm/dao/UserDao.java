package com.ssm.dao;

import com.ssm.entity.User;

public interface UserDao {
	/**
	 * 通过用户名查询用户
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * 添加用户
	 * @param manager
	 * @return
	 */
	public Integer add(User user);
}
