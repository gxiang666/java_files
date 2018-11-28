package com.tnti.array1;


public class Array {
	private int[] data;		//数组
	private int size;		//大小，元素个数
	
	public Array(int capacity) {  //容量
		data = new int[capacity];
		size = 0;
	}
	
	public Array() {
		this(10);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getCapacity() {
		return data.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
//	public void addLast(int e) {
//		
//		if(size == data.length) {
//			throw new IllegalArgumentException("add failed");
//		}
//		data[size] = e;
//		size ++;
//	}
	
	public void addLast(int e) {
		add(size, e);
	}
	
	public void addFirst(int e) {
		add(0, e);
	}
	
	//在任意位置插入元素
	public void add(int index, int e) {
		if(size == data.length) {
			throw new IllegalArgumentException("add failed");
		}
		
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("add failed");
		}
		for(int i = size - 1; i >= index; i --) {
			data[i + 1] = data[i];
		}
		
		data[index] = e;
		size ++;
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size=%d, capacity = %d\n", size, data.length));
		res.append("[");
		for(int i = 0; i < size; i ++) {
			res.append(data[i]);
			if(i != size - 1) {
				res.append(",");
			}
		}
		res.append("]");
		return res.toString();
	}
	
	
	
	
}
