package com.ssm.dao;

import com.ssm.entity.User;

public interface UserDao {
	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public User getByUserName(String userName);
	
	/**
	 * ����û�
	 * @param manager
	 * @return
	 */
	public Integer add(User user);
}
