package com.tnti.sessionTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Demo3() {
    	
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		// 获取session的属性
		String c = (String) session.getAttribute("c");
		String f = (String) session.getAttribute("f");
		System.out.println(c);
		System.out.println(f);
	}

}
