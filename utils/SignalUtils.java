public calss SingnalUtils{

	private static DataSource ds = null;

	private DBCPDataSource(){
	}

	public static DataSource getDataSource(){
		if(ds == null){
			Properties prop = new Properties();
			prop.load(DBCPDataSource.class.getClassLoader().getResourceAsSteam("db.properties"));
			ds = BasicDataSourceFactory.createSource(prop);
		}
		return ds;
	}


	public static void main(Sting[] args){
		String sql = "select * from ADMINIFO";
		List<AdminInfoBean> lst = NewInstance.getInstance(DBProvider.class).query(sql,new BeanListHandler<AdminInfoBean>(AdminInfoBean.class));
		if(lst != null && lst.size() > 0){
			for(AdminInfoBean adminnInfobean : lst)
				System.out.println(adminnInfobean.toString());
		}
	}
}