package com.tnti.service;

import com.tnti.bean.User;

public class UserService {
	
	private User user;
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void printUser() {
		System.out.println(user);
	}
	
	public void sayHello() {
		System.out.println("hello world");
	}

}
