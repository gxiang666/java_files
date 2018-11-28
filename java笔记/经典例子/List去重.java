package com.tnti.listdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 利用set不重复的特性对list去重
 * 
 * 对基本数据类型去重
 * @author 熊高祥
 *
 */
public class Test01 {
	public static void main(String [] args) {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(12);
		list.add(14);
		list.add(13);
		list.add(11);
		
		List<Integer> newList = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		set.addAll(list);
		newList.addAll(set);
		
		
		System.out.println(newList);
		
		System.out.println(set);
		
		
		System.out.println(list);
		
	}
}


package com.tnti.listdemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * List里面是对象类型时去重
 * 
 * @author 熊高祥
 *
 */
public class Test02 {

	public static void main(String[] args) {
		List<People> list = new ArrayList<>();

		list.add(new People("zhangsan", "1111"));
		list.add(new People("lisi", "2222"));
		list.add(new People("zhangsan", "1111"));
		list.add(new People("zhangsan", "3333"));

		Set<People> set = new HashSet<>();
		set.addAll(list);

		System.out.println(list);
		System.out.println(set);

	}

}

class People {

	private String name;
	private String phoneNumber;



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public People() {

	}

	public People(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public boolean equals(Object obj) {

		People p = (People) obj;
		return name.equals(p.name) && phoneNumber.equals(p.phoneNumber);
	}
	
	@Override
	public int hashCode() {
		String str = name + phoneNumber;
		return str.hashCode();
	}

}
