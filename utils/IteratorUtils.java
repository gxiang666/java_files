public class IteratorUtils{

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add("zhangsan");	

		Iterator it = list.iterator();
		while(it.hasNext){
			Object obj = it.next();
			String str = (String) obj;
			System.out.println(str);
		}
	}
}