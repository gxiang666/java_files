package com.tnti.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端socket
 * @author 熊高祥
 *
 */
public class TCPClient {
	public static void main(String[] args) {
		try {
			//建立一个客户端Socket,指定本地IP，和要连接的端口，连接到服务端
			Socket s = new Socket("127.0.0.1", 6666);
			//获得输出流对象
			OutputStream os = s.getOutputStream();
			//在外再包装一层方便输出
			DataOutputStream dos = new DataOutputStream(os);
			//以UTF-8的形式输出字符串
			dos.writeUTF("hello server");
			dos.flush();
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
