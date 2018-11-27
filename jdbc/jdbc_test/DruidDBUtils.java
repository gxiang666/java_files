public class DruidDBUtils{

	private static DruidDataSource dds;

	static {
		dds = new DruidDataSource();
		dds.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
		dds.setUsername("root");
		dds.setPassword("root");
	}

	public static DataSource getDDS(){
		return dds;
	}

	public static Connection getDBConn(){
		try{
			return dds.getConnection();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return null;
	}
}


class DBUtilsTest{

	public void addStu(Student stu) throws SQLException{

		String sql = "insert into stu_info(stu_num, stu_name, stu_age,stu_gender) value(?,?,?,?)";
		Connection conn = DBUtils.getConnection();
		QueryRunner qr = new QueryRunner();
		qr.update(conn, sql, dui.gerStuNum(),udi.getStuName(),dui.getStuAge(), udi.getStuGender());
		conn.close();		
	}
}