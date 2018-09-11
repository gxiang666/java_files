package com.tnti.gui;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * 制作菜单条
 * 
 * @author 熊高祥
 *
 */
public class MyMenubar {

	private Frame frame; // 窗口
	private MenuBar menuBar; // 菜单条
	private Menu menu; // 菜单
	private MenuItem closeItem;

	public MyMenubar() {
		init();
	}

	public void init() {
		frame = new Frame("my window");
		frame.setBounds(300, 100, 500, 600);
		frame.setLayout(new FlowLayout());

		menuBar = new MenuBar();
		menu = new Menu("file");
		closeItem = new MenuItem("exit");

		menu.add(closeItem);
		menuBar.add(menu);
		frame.setMenuBar(menuBar);

		myEvent();

		frame.setVisible(true);
	}

	public void myEvent() {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new MyMenubar();
	}
}
