package com.tnti.collectionTest;

import java.util.Comparator;

/**
 * 比较器
 * @author 熊高祥
 *
 */
public class Demo2 {
	public static void main(String[] args) {
		int x = new Integer(10).compareTo(new Integer(20));
		System.out.println(x);
	}
}


class MyComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int  num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
		if(num == 0)
			return o1.compareTo(o2);
		return num;
	}
	
	
}