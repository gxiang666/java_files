package com.tnti.myaspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
 * 切面类后置通知1
 * 在方法结束后执行
 * @author 熊高祥
 *
 */
public class MyAspect04 implements AfterReturningAdvice {
	
	
	/**
	 * returnValue  目标类的返回值
	 * method 		目标类的方法
     * args   		目标类的参数
     * target       目标类
	 */
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass().getName() + "的" + method.getClass().getName() + "被执行了，返回值是" + returnValue);
	}

}
