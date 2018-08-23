package com.tnti.dao;

import com.tnti.entity.User;

public class UserDao {
	//登录
	public User login(User user) {
		if("siggy".equals(user.getName()) && "1111".equals(user.getPwd())) {
			return user;
		}
		return null;
	}
}
