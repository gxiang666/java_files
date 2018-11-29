package com.tnti.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


/**
 * 通过单例模式获取sqlSessionFactory
 * @author Admin
 *
 */
public class SqlSessionFactoryUtil {
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	private SqlSessionFactoryUtil() {
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() throws IOException {
		
		if(sqlSessionFactory == null) {
			InputStream is = Resources.getResourceAsStream("mybatis.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		}
		
		return sqlSessionFactory;
	}
	
	
}
