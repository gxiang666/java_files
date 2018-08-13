package com.demos;

import java.util.List;

import com.demos.entity.User;
import com.demos.service.IUserService;
import com.demos.service.UserServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	IUserService userService = new UserServiceImpl();
	   
	/**
	 * 测试查询用户列表
	 */
	public void testListUser()
    {
         List<User> listUser = userService.listUser();
         for(User user:listUser) {
        	 System.out.println(user);
         }
    }
    public static void main( String[] args )
    {
    	App app = new App();
    	app.testListUser();
    }
    
}
