package com.tnti.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tnti.dao.UserDao;
import com.tnti.entity.User;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserDao userDao = new UserDao();
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的编码， 解决乱码
		request.setCharacterEncoding("utf-8");
		User user = new User();
		user.setName(request.getParameter("name"));
		//user.setId(Integer.parseInt(request.getParameter("id")));
		user.setPwd(request.getParameter("pwd"));
		user = userDao.login(user);
		if(user != null) {
			//登陆成功
			//获取session并设置属性值
			request.getSession().setAttribute("user", user);
			//重定向
			response.sendRedirect("index.jsp");
		}else {
			//设置request的属性和请求转发
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("login.jsp").forward(request,  response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
