package com.tnti.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 鼠标和键盘监听
 * @author 熊高祥
 *
 */
public class MouseAndKeyEvent {
	protected static final int VK_ENTER = 0;
	private Frame f; // 窗口
	private Button but; // 按钮

	public MouseAndKeyEvent() {
		init();
	}
	
	/**
	 * 初始化
	 */
	public void init() {
		f = new Frame("my window");
		f.setBounds(300, 100, 600, 500); // (距离屏幕左边，距离屏幕上边，长，宽)
		f.setLayout(new FlowLayout());

		but = new Button("button");
		f.add(but);
		myEvent();
		f.setVisible(true);

	}
	private void myEvent() {
		f.addWindowListener(new WindowAdapter() {	//窗口监听
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		but.addMouseListener(new MouseAdapter(){	//鼠标监听
			private int count = 1;
			private int clickCount = 1;
			
			public void mouseEntered(MouseEvent e) {
				System.out.println("鼠标进入该组件" + count++);
			}
			
			public void mouseClicked(MouseEvent e) {	
				if(e.getClickCount()==2) {
					System.out.println("双击动作" + clickCount++);
				}
			}
		});
		
		but.addKeyListener(new KeyAdapter() {	//键盘监听
			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.exit(0);
//				}
				
				if(e.isControlDown() && e.getKeyCode()== KeyEvent.VK_ENTER) {
					System.out.println("ctrl + enter is run");
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new MouseAndKeyEvent();
	}
}
