package com.tnti.collectionTest;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Demo5 {
	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>(new LenComparator2());
		ts.add("abcd");
		ts.add("cc");
		ts.add("cba");
		ts.add("aaa");
		ts.add("z");
		ts.add("hahaha");
		
		Iterator<String> it = ts.iterator();
		
		while(it.hasNext()) {
			String  s = it.next();
			System.out.println(s);
		}
	}
}


/**
 * 按照字符串从短到长排列
 * @author 熊高祥
 *
 */
class LenComparator1 implements Comparator<String>{
	public int compare(String o1, String o2) {
		int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num == 0) {
			return o1.compareTo(o2);
		}
		return num;
	}
}



/**
 * 按照字符串从长到短排列
 * @author 熊高祥
 *
 */
class LenComparator2 implements Comparator<String>{
	public int compare(String o1, String o2) {
		int num = new Integer(o2.length()).compareTo(new Integer(o1.length()));
		if(num == 0) {
			return o2.compareTo(o1);
		}
		return num;
	}
}
