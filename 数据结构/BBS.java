package com.tnti.bbs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二分搜索树:插入的时候都是从根节点开始，左子树比根节点小，右子树比根节点大
 * 
 * @author 熊高祥
 *
 */
public class BBS<E extends Comparable<E>> {

	private class Node {
		public E e;
		public Node left, right; // 左子树，右子树

		public Node(E e) {
			this.e = e;
			left = null;
			right = null;
		}
	}

	private Node root; // 根节点
	private int size;// 元素个数

	public BBS() {
		root = null;
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// 向二分搜索树中添加新的元素e
	public void add(E e) {
		if (root == null) {
			root = new Node(e);
			size++;
		} else {
			add(root, e);
		}
	}

	// 向以node为根的二分搜索树中插入元素e，递归算法
	private void add(Node node, E e) {
		if (e.equals(node.e)) {
			return;
		} else if (e.compareTo(node.e) < 0 && node.left == null) {
			node.left = new Node(e);
			size++;
			return;
		} else if (e.compareTo(node.e) > 0 && node.right == null) {
			node.right = new Node(e);
			size++;
			return;
		}

		if (e.compareTo(node.e) < 0) {
			add(node.left, e);
		} else {
			add(node.right, e);
		}
	}

	public void add2(E e) {
		root = add2(root, e);
	}

	/**
	 * 返回插入新节点后二分搜索树的根
	 * 
	 * @param node
	 * @param e
	 * @return
	 */
	private Node add2(Node node, E e) {
		if (node == null) {
			size++;
			return new Node(e);
		}

		if (e.compareTo(node.e) < 0) {
			node.left = add2(node.left, e);
		} else if (e.compareTo(node.e) > 0) {
			node.right = add2(node.right, e);
		}
		return node;
	}

	public boolean contains(E e) {
		return contains(root, e);
	}

	private boolean contains(Node node, E e) {

		if (node == null) {
			return false;
		}

		if (e.compareTo(node.e) == 0) {
			return true;
		} else if (e.compareTo(node.e) < 0) {
			return contains(node.left, e);
		} else { // else if(e.compareTo(node.e) > 0)
			return contains(node.right, e);
		}
	}

	// 二分搜索树的前序遍历
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.e);
		preOrder(node.left);
		preOrder(node.right);
	}

	// 中序遍历
	public void inOrder() {
		inOrder(root);
	}

	// 中序遍历以node为根的二分搜索树，递归算法
	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.println(node.e);
		inOrder(node.right);
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		generateBBSString(root, 0, res);
		return res.toString();
	}

	// 生成以node为根节点，深度为depth的描述二叉树的字符串
	private void generateBBSString(Node node, int depth, StringBuilder res) {
		if (node == null) {
			res.append(generateDepthString(depth) + "null\n");
			return;
		}

		res.append(generateDepthString(depth) + node.e + "\n");
		generateBBSString(node.left, depth + 1, res);
		generateBBSString(node.right, depth + 1, res);
	}

	private String generateDepthString(int depth) {
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			res.append("--");
		}
		return res.toString();
	}

	// 二分搜索树的非递归前序遍历
	public void preOrderNR() {

		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node cur = stack.pop(); // 取出栈顶的元素
			System.out.println(cur.e);
			if (cur.right != null) {
				stack.push(cur.right); // 往栈中放入元素
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
	}

	// 二分搜索树的层序遍历
	public void levelOrder() {

		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			Node cur = q.remove();
			System.out.println(cur.e);

			if (cur.left != null) {
				q.add(cur.left);
			}
			if (cur.right != null) {
				q.add(cur.right);
			}
		}
	}

	// 寻找二分搜索树的最小元素
	// 最小值在最左边
	public E minimum() {
		if (size == 0) {
			throw new IllegalArgumentException("BBS is empty");
		}
		return minimum(root).e;
	}

	// 返回以node为根的二分搜索树的最小值所在的节点
	// 最大值在最右边
	public Node minimum(Node node) {
		if (node.left == null) {
			return node;
		}

		return minimum(node.left);
	}

	// 寻找二分搜索树的最大元素
	public E maximum() {
		if (size == 0) {
			throw new IllegalArgumentException("BBS is empty");
		}
		return maximum(root).e;
	}

	// 返回以node为根的二分搜索树的最大值所在的节点
	public Node maximum(Node node) {
		if (node.right == null) {
			return node;
		}

		return minimum(node.right);
	}

	// 从二分搜索树中删除最小值所在的节点，并返回最小值
	public E removeMin() {
		E ret = minimum();
		root = removeMin(root);
		return ret;
	}

	// 删除以node为根的二分搜索树中的最小节点
	// 返回删除节点后新的二分搜索树的根
	private Node removeMin(Node node) {
		if (node.left == null) {
			Node rightNode = node.right;
			node.right = null;
			size--;
			return rightNode;
		}
		node.left = removeMin(node.left);
		return node;
	}
}
