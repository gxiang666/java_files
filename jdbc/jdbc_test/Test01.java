package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class Test01 {

	public static void main(String[] args) throws FileNotFoundException {
		FileReader fileReader = new FileReader("conf/server.properties");
		Properties pro = new Properties();
		Connection conn = null;
		Statement stmt = null;
		try {
			pro.load(fileReader);
			fileReader.close();
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			int count;
			// 1.注册驱动
			Class.forName(driver);
			// 2.获取数据库连接
			conn = DriverManager.getConnection(url, user, password);
			//3.获取数据库操作对象
			stmt = conn.createStatement();
			//4.执行SQL语句
			String sql = "insert into websites(id,name,url,alexa,country) values(7,'百度','https://www.baidu.com','30','CN')";
			count = stmt.executeUpdate(sql);
			System.out.println(count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
