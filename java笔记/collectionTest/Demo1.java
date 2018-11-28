package com.tnti.collectionTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 泛型的使用
 * 
 * @author 熊高祥
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();
		a.add("1");
		a.add("gaoxiang");
		
		//遍历List
		for (int i=0; i<a.size(); i++) {
			String str = a.get(i);
			System.out.println(str);
		}
		
		for (String s : a) {
			System.out.println(s);
		}
		
		//通过迭代器取值
		Iterator<String> it = a.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
