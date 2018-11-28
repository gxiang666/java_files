package com.tnti.myaspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 *     切面类
 *  前置通知1
 * @author 熊高祥
 *
 */
public class MyAspect03 implements MethodBeforeAdvice {
	
	/**
	 * method 目标类的方法
	 * args 目标类的参数
	 * target 目标类
	 * 
	 */
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass().getName() + "的" + method.getClass().getName() + "被执行了");
	}
}


