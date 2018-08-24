package com.tnti.filterTest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 乱码过滤
 */
public class CharactterEncodingFilter implements Filter {

	//提升作用域
	String encoding = null;
    public CharactterEncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//首先在<filter>标签中设置encoding编码
//	    <init-param>
//    		<param-name>encoding</param-name>
//    		<param-value>utf-8</param-value>
//    	</init-param>
		if(encoding==null || "".equals(encoding)) {
			encoding = "utf-8";
		}
		//设置请求的编码,setCharacterEncoding只能解决post请求
		request.setCharacterEncoding(encoding);
		//设置响应的编码
		response.setCharacterEncoding(encoding);
		chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest)request) {
			@Override
			public String getParameter(String name) {
				//单独处理get请求
				if("get".equals(this.getMethod().toLowerCase())){
					String value = super.getParameter(name);
					try {
						return new String(value.getBytes("ido-8859-1"), encoding);
						
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return value;
		}
				return super.getParameter(name);
			}
		}, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//在web.xml中设置配置，通过filterConfig读取
		//然后通过init初始化
		encoding = fConfig.getInitParameter("encoding");
	}

}
