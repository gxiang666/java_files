package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Test03 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//MySQL：URL
			String url = "jdbc:mysql://localhost:3306/RUNOOB?serverTimezone=UTC&useSSl=false";
			//MySQL用户
			String user = "root";
			//MySQL密码
			String pwd = "123456";
			
			//注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//与数据库建立连接
			conn = DriverManager.getConnection(url, user, pwd);
			
			//要执行的sql语句
			String sql = "select * from websites";
			//对sql语句进行预编译
			ps = conn.prepareStatement(sql);
			//执行sql语句
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String urls = rs.getString("url");
				int alexa = rs.getInt("alexa");
				String country = rs.getString("country");
				System.out.println(id + "\t" + name + "\t" + urls + "\t" + alexa + "\t" + country);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
