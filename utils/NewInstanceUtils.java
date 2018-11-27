public class NewInstanceUtils{
	public static <T> T getInstance(Class<T> clazz){
		T t = null;
		try{
			t = clazz.newInstance();
		}catch(Exception e){
			System.out.println("获取实例异常对象" + e.getMessage);
			e.printStackTrace();
		}

		return t;
	}
}