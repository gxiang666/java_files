package com.tnti.flectionDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射获取对象的属性和方法
 * 
 * @author 熊高祥
 *
 */
@SuppressWarnings("all")  //抑制所有警告
public class Demo1 {
	public static void main(String[] args) {
		try {
			Class clazz = Class.forName("com.tnti.flectionDemo.User");
			
			//获取属性
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				System.out.println(f);
			}
			Field field = clazz.getDeclaredField("id");
			System.out.println(field);
			
			//获取方法
			Method[] methods = clazz.getDeclaredMethods();
			for (Method m : methods) {
				System.out.println(m);
			}
			//如果方法有参数，必须给出对应类型的.class对象
			Method method = clazz.getDeclaredMethod("getUname", null);
			System.out.println(method);

			//获取构造器
			//1.获取全部构造器
			Constructor[] constrcutor = clazz.getConstructors();
			for (Constructor con : constrcutor) {
				System.out.println(con);
			}
			//无参构造器
			Constructor c1 = clazz.getConstructor(null);
			System.out.println(c1);
			//有参构造器
			Constructor c2 = clazz.getConstructor(String.class, int.class, int.class);
			System.out.println(c2);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
}
