package com.tnti.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyWindowDemo {
	private Frame f; // 窗口
	private TextField tf; // 文本框
	private Button but; // 按钮
	private TextArea ta; // 文本区域
	private Dialog d; // 对话窗口

	public MyWindowDemo() {
		init();
	}
 
	/**
	 * 初始化
	 */
	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500); // (距离屏幕左边，距离屏幕上边，长，宽)
		f.setLayout(new FlowLayout());

		tf = new TextField(50); // 只能指定列

		but = new Button("click");

		ta = new TextArea(25, 60);

		f.add(tf);
		f.add(but);
		f.add(ta);

		myEvent();
		f.setVisible(true);

	}

	/**
	 * 监听事件
	 */
	private void myEvent() {

		but.addActionListener(new ActionListener() {

			@Override // 读取文件夹
			public void actionPerformed(ActionEvent e) {
				String dirPath = tf.getText();
				File dir = new File(dirPath);
				if (dir.exists() && dir.isDirectory()) {
					ta.setText("");
					String[] names = dir.list();
					for (String name : names) {
						ta.append(name + "\r\n");
					}
				}
			}
		});

		f.addWindowListener(new WindowAdapter() { // 窗口监听

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			} // 匿名内部类：new一个父类当做一个类使用,相当于继承父类
		});

//		but.addActionListener(new ActionListener() {	//按钮监听
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("退出，是按钮干的");
//				System.exit(0);
//			}
//		});
	}

	public static void main(String[] args) {
		new MyWindowDemo();
	}
}

class MyWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}