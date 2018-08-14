package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test04 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String url = "jdbc:mysql://localhost:3306/RUNOOB?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String password = "123456";
			
			//注册驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//连接数据库
			conn = DriverManager.getConnection(url, user, password);
			
			//对SQL语句进行预编译
			//String sql = "select * from websites where name=?"; 当需要用到赋值的时候，赋值的地方用？号 
			//ps = conn.prepareStatement(sql);  先预编译后赋值
			//ps.setString(1, "Google");   (?号的位置：从一开始， 要赋的值：可以是具体值也可以是变量）
			String sql = "select * from websites";
			ps = conn.prepareStatement(sql);
			
			//结果集对象
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + rs.getString("name") + rs.getString("url") + rs.getInt("alexa") + rs.getString("country"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
