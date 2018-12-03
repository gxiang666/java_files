package com.tnti.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.tnti.bean.User;
import com.tnti.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User selectUserById(int id) {

		// 创建session
		SqlSession sqlSession = sqlSessionFactory.openSession();
		// 调用sqlSession的增删改查方法
		// 第一个参数：表示statement的唯一标示
		User user = sqlSession.selectOne("com.tnti.bean.UserMapper.selectUsertById", id);
		// 关闭资源
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> selectUsersAll() {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("com.tnti.bean.UserMapper.selectUserAll");
		sqlSession.close();
		return list;
	}

	@Override
	public int insertUser(User user) {

		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.insert("com.tnti.bean.UserMapper.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return result;

	}

	@Override
	public int deleteUser(int id) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.delete("com.tnti.bean.UserMapper.deletetUser", id);
		sqlSession.commit();
		sqlSession.close();		
		return result;
	}

	@Override
	public int updateUser(User user) {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.update("com.tnti.bean.UserMapper.updateUser", user);
		sqlSession.commit();
		sqlSession.close();
		return result;
	}
}
