package com.demos.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@WebFilter(urlPatterns = {"/user/*"}, filterName = "LoginFilter")
public class LoginFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		Object username = session.getAttribute("username");
		
		if(null != username) {
			chain.doFilter(request, response);
		}else {
			logger.debug("LoginFilter session timeout......");
			String contextPath = req.getContextPath();
	        session.setAttribute("ctx", contextPath);
			res.sendRedirect(contextPath+"/login");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("--------------LoginFilter init------------------");
	}

}
