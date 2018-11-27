package com.tnti.flectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射操作构造方法，属性，方法
 * @author 熊高祥
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		try {
			
			//调用无参构造器
			Class<User> clazz = (Class<User>) Class.forName("com.tnti.flectionDemo.User");
			User user= clazz.getConstructor(null).newInstance();
			
			//调用有参构造器
			Constructor<User> c = clazz.getConstructor(String.class, int.class, int.class);
			User u = /*(User)*/ c.newInstance("gaxoaing", 23, 1001);
			System.out.println(u);
			
			//调用普通方法
			User u2 = clazz.getConstructor(null).newInstance();
			Method method = clazz.getMethod("setUname", String.class);
			method.invoke(u2, "gaoxaing");//激活
			System.out.println(u2.getUname());
			
			//操作私有属性
			User u3 = clazz.getConstructor().newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true); // 这个属性不做检查，可以直接访问
			field.set(u3, "hha");   //通过反射直接写属性
			System.out.println(u3.getUname());  //通过反射直接读反射
			System.out.println(field.get(u3));
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
