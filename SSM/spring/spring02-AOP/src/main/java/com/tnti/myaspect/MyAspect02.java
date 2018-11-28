package com.tnti.myaspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect02{
	@Before("*  com.tnti.service.impl.*.*(..)")
	public void before() {
		System.out.println("方法执行前-------------");
	}
	
	@After("*  com.tnti.service.impl.*.*(..)")
	public void after() {
		System.out.println("方法执行后---------");
	}
	
	@Around("*  com.tnti.service.impl.*.*(..)")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("环绕前----------");
		//执行方法
		Object obj = jp.proceed();
		System.out.println("环绕后----------");
		return obj;
	}
}




/*import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

*//**
 *     切面类
 *  环绕通知2
 * @author 熊高祥
 *
 *//*
public class MyAspect02 implements MethodInterceptor {
	
	
	*//**
	 * target 目标类
	 * method 目标类的方法
	 * args 目标类的参数
	 * method 代理类的代理方法
	 *//*
	public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("前三");		
		System.out.println("后三");
		
		return null;
	}

}
*/

