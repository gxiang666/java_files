package com.tnti.collectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 获取Map的key,value
 * @author 熊高祥
 *
 */
public class Demo4 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("01", "zhangsan01");
		map.put("03", "zhangsan");
		map.put("02", "zhangsan02");
		System.out.println(map);
		//先获取map集合的所有键的set集合，keyset
		Set<String> keySet = map.keySet();
		
		//有了set集合，就可以获取其迭代器
		Iterator<String> it = keySet.iterator();
		while(it.hasNext()) {
			String key = it.next();
			String value = map.get(key);
			//有了键可以通过map集合的get方法获取其对应的值
			System.out.println("key:" + key + ",value:" + value);
		}
	}
}
