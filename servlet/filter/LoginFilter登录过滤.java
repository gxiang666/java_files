package com.tnti.filterTest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *登录过滤
 *检查用户是否登录，如果没有登录，那么跳转登录页面
 *如果用户登录，那么进入下一个filter
 */
public class HelloFilter implements Filter {

    public HelloFilter() {
    }

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//强制转型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//获取请求的URL
		//System.out.println("url:" + req.getRequestURL());
/*		String path = req.getRequestURL().substring(req.getRequestURL().lastIndexOf("/") + 1);
		System.out.println("path:" + path);
		
		if("login.jsp".equals(path) || "login".equals(path)) {
			chain.doFilter(request, response);
			return ;
		}
		
		Object obj = req.getSession().getAttribute("user");
		if(obj == null) {
			resp.sendRedirect("login.jsp");
			return ;
		}
		chain.doFilter(request, response);
	}
*/
		
		Object obj = req.getSession().getAttribute("user");
		if(obj == null) {
			String path = req.getRequestURL().substring(req.getRequestURL().lastIndexOf("/") + 1);
			if(!("login.jsp".equals(path) || "login".equals(path))) {
				resp.sendRedirect("login.jsp");
				return ;
			}
		}
		chain.doFilter(request, response);
		
		}
		
		
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
