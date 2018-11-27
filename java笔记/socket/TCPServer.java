package com.tnti.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端socket
 * @author 熊高祥
 *
 */
public class TCPServer {
	public static void main(String[] args) {
		try {
			//创建一个服务端socket,并绑定一个服务端端口，通过这个端口就行数据通信
			ServerSocket ss = new ServerSocket(6666);
			
			//只要有客户端连接都接受
			while(true) {
				//接受客户端的连接
				Socket s1 = ss.accept();
				//获取输出流对象
				DataInputStream dis = new DataInputStream(s1.getInputStream());
				//输出内容
				System.out.println(dis.readUTF());
				dis.close();
				s1.close();
//				System.out.println("a client connect");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
