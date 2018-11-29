package com.tnti.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tnti.bean.User;
import com.tnti.dao.IUserDao;


/**
 * 通过mapper代理自动生成dao接口的实例
 * @author Admin
 *
 */
public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//获得dao接口的实例【无需写实现类，mybatis自动创建并返回】
		IUserDao mapper = sqlSession.getMapper(IUserDao.class);
		User user =  mapper.selectUsertById(2);
		sqlSession.close();
		System.out.println(user);
		
	}
}
