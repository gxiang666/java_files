package com.demos.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demos.mapper.UserMapper;
import com.demos.model.User;

@Service(value = "userService")
public class UserServiceImpl implements IUserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> list(User user, int pageIndex, int pageSize) {
		return userMapper.list(user, pageIndex, pageSize);
	}
	
	@Override
	public int count(User user) {
		return userMapper.count(user);
	}
	
	@Override
	@Transactional
	public int insert(User uesr) {
		userMapper.insert(uesr);
		return uesr.getId();
	}

	@Override
	@Transactional
	public int update(User user) {
		return userMapper.update(user);
	}

	@Override
	@Transactional
	public int delete(Integer id) {
		return userMapper.delete(id);
	}
}
