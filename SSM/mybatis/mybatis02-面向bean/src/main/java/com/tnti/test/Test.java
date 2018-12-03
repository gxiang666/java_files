package com.tnti.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import com.tnti.bean.User;
import com.tnti.dao.IUserDao;
import com.tnti.dao.impl.UserDaoImpl;
import com.tnti.utils.SqlSessionFactoryUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		IUserDao userDao = new UserDaoImpl(sqlSessionFactory);
	
		
		/*//增加用户
		User user = new User();
		user.setAddress("heNan");
		user.setId(10);
		user.setSex("男");
		user.setUsername("gaoxiang");
		int result = userDao.insertUser(user);
		System.out.println(result);*/
		
		/*//修改用户
		User user = new User();
		user.setAddress("CN");
		user.setId(10);
		user.setSex("男");
		user.setUsername("xionggaoxiang");
		int result = userDao.updateUser(user);
		System.out.println(result);*/
		
		/*//删除用户    false:可能和主键自动增长有关
		int result = userDao.deleteUser(1);
		System.out.println(result);*/
		
		/*//通过id查询用户
		 User user = userDao.selectUserById(2);
		 System.out.println(user);*/
		
		//查询所有用户
		List<User> list = userDao.selectUsersAll();
	
		for(User u : list) {
			System.out.println(u);
		}
		
	}
}
