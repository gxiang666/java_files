package com.tnti.collectionTest;


/**
 * 重写equals
 * @author 熊高祥
 *
 */
public class Demo3 {
	public static void main(String[] args) {
		Cat c1 = new Cat(1,1,1);
		Cat c2 = new Cat(1,1,1);
		System.out.println(c1.equals(c2));
	}
}


class Cat{
	int color;
	int height, weight;
	public Cat(int color, int height, int weight) {
		this.color = color;
		this.height = height;
		this.weight = weight;
	}
	
	
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof Cat) {
			Cat c = (Cat) obj;
			if(c.color == this.color && c.height == this.height && c.weight == this.weight) {
				return true;
			}
		}
		return false;
	}
}