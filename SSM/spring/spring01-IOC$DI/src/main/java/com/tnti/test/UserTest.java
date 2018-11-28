package com.tnti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tnti.service.UserService;

public class UserTest {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("spring.xml");
		UserService us = (UserService) app.getBean("userService");

		us.printUser();
		us.sayHello();

	}
}
