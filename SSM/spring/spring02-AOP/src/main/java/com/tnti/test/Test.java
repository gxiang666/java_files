package com.tnti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tnti.service.IUserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		IUserService us = (IUserService) app.getBean("userService");

		us.addUser();

	}

}
