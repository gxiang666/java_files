package com.tnti.myaspect;

/**
 * 自定义通知
 * 
 * @author 熊高祥
 *
 */
public class MyAspect05 {
	
	public void before() {
		System.out.println("------方法执行前-----------");
	}

	public void after() {
		System.out.println("------方法执行后-----------");
	}
}
