package com.demos.service;

import java.util.List;

import com.demos.model.User;

public interface IUserService {
	
	List<User> list(User user,int pageIndex,int pageSize);
	int count(User user);
	int insert(User user);
	int update(User user);
	int delete(Integer id);
}
