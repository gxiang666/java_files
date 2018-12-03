package com.tnti.dao;

import com.tnti.bean.User;

public interface IUserDao {

	// 根据用户ID查询用户信息
	public User selectUsertById(int id);

}
