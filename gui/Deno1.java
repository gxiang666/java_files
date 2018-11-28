package com.tnti.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Deno1 {
	public static void main(String[] args) {
		Frame f = new Frame("my awt");	//创建窗口并设置标题
		f.setSize(500,400);		//设置大小
		f.setLocation(300, 200);	//设置位置
		f.setLayout(new FlowLayout());		//设置布局
		
		Button button = new Button("button");	//创建按钮
		f.add(button);
		
		f.addWindowListener(new WindowAdapter() {	//匿名内部类
			public void windowClosing(WindowEvent e) {
				System.out.println("关闭窗口");
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent e) {
				System.out.println("激活前置");
			}
			
			public void windowOpened(WindowEvent e) {
				System.err.println("打开窗口");
			}
		});
		
		f.setVisible(true);
	}
}
