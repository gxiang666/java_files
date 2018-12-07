package com.demos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.demos.model.User;

public interface UserMapper {
	
	List<User> list(@Param("user") User user,@Param("pageIndex") int pageIndex,@Param("pageSize") int pageSize);
	int count(@Param("user") User user);
	int insert(User user);
	int update(User user);
	int delete(Integer id);
}