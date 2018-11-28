package com.tnti.myaspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 *     切面类
 *  环绕通知1
 *  在方法开始和结束后执行
 * @author 熊高祥
 *
 */
public class MyAspect01 implements MethodInterceptor {
	
	
	/**
	 * invocation  目标类的方法
	 */
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("前三");
		Object obj = invocation.proceed();
		System.out.println("后三");
		
		return obj;
	}
	
}


