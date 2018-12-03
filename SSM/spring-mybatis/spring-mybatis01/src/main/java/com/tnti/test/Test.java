package com.tnti.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tnti.bean.User;
import com.tnti.dao.IUserDao;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext appc = new ClassPathXmlApplicationContext("configs/spring.xml");
		IUserDao userDao = (IUserDao) appc.getBean("userDao");
		User user = userDao.selectUsertById(1);
		System.out.println(user);
	}
}
