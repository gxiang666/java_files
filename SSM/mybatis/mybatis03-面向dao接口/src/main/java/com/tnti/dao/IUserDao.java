package com.tnti.dao;

import java.util.List;

import com.tnti.bean.User;

public interface IUserDao {
	
	//根据用户ID查询用户信息
	public User selectUsertById(int id);
	
	//根据用户名称模糊查询用户列表
	public List<User> selectUsersAll();
	
	//添加用户
	public int insertUser(User user);
	
	//修改用户
	public int updateUser(User user);
	
	//删除用户
	public int deleteUser(int id);
}
