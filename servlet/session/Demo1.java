package com.tnti.sessionTest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 获取session对象
 * @author Admin
 *
 */
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Demo1() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应的格式
		response.setContentType("text/html; charset=utf-8");
		//通过response对象获取打印流对象
		PrintWriter pw = response.getWriter();
		
		//建立session: 1.true:先去查找是否有session，有就用，沒有就創建
		// 2.false:沒有這不創建
		//session只要创建和网页的关闭无关，和浏览器的关闭有关，只要浏览器没关，无论怎么访问session都在
		HttpSession session = request.getSession(false);
		if (session == null) {
			pw.println("欢迎第一访问");
			HttpSession ss = request.getSession();
			//销毁session对象
			//1.使用invalidate();
			//2.(1)在tomcat的conf下得web.xml中设置失效时间，这个是全局的servlet,时间的分钟
//			  <session-config>
//			  	<session-timeout>1</session-timeout>
//			  </session-config>
			//2(2)在工程下的webcontent下的web.xml中配置失效时间，只对这个工程有效
			ss.invalidate();
		} else {
			pw.println("欢迎回来");
		}
	}

}
