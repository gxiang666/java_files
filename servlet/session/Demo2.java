package com.tnti.sessionTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 设置session
 * @author Admin
 *
 */
public class Demo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Demo2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//获取请求表单的数据   http://localhost:8080/thirdWebDemo/Demo2?c=c
		//key-value request.getParameter("key")
		String name = request.getParameter("c");  
		if("c".equals(name)) {
			//设置session的值
			session.setAttribute("C", "chrom");
		} else {
			session.setAttribute("f", "firfox");
		}
		
	}

}
