package com.tnti.linkedList;



/**
 * 链表：数据存储在节点(Node)中
 * class Node{
 * 		E e;
 * 		Node next;
 * }
 * @author 熊高祥
 *
 * @param <E>	泛型
 */
public class LinkedList<E> {
	
	private class Node{
		public E e;
		public Node next;
		
		public Node(E e, Node next) {
			this.e = e;
			this.next = next;
		}
		
		public Node(E e) {
			this(e, null);
		}
		
		public Node() {
			this(null, null);
		}
		
		public String toString() {
			return e.toString();
		}
	}
	
	private Node head;	//头节点
	private int size;		//元素个数
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	//在链表头添加新的元素e
	public void addFirst(E e) {
//		Node node = new Node(e);
//		node.next = head;
//		head = node;
		
		head = new Node(e, head);
		size ++;
	}
	
	//在链表的index(0-based)位置添加新的元素e
	//在链表中不是一个常用的操作
	public void add(int index,E e) {
		
		if(index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed, Illegal index");
		}else {
			Node prev = head;
			for (int i =0; i < index - 1; i ++) {
				prev = prev.next;
			}
//			Node node = new Node(e);
//			node.next = prev.next;
//			prev.next = node;
			
			prev.next = new Node(e, prev.next);
			size ++;
		}
	}
	
	//在链表的末尾添加新的元素
	public void addLast(E e) {
		add(size, e);
	}
}

