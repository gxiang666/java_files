package com.tnti.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.tnti.bean.User;

public class Test {

	public static void main(String[] args) throws IOException {
		InputStream is =Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("com.tnti.bean.UserMapper.selectById", 1);
		System.out.println(user);
		sqlSession.close();
	}
}
