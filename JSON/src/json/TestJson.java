package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 *	json字符串 转为 java对象 
 *
 */
public class TestJson {

	@Test
	public void test() {
		Student stu = new Student("名字",18);
		String str = stu.toString();
		System.out.println(str);
		
		Gson gson = new Gson();
		String json = gson.toJson(stu);
		System.out.println(json);
	}
	@Test
	public void test2() {
		Student stu = new Student("名字",18);
		Gson gson = new Gson();
		String json = gson.toJson(stu);
		
		Student stu2 = gson.fromJson(json, Student.class);
		System.out.println(stu2);
	}
	
	@Test
	public void test3() {
		Student stu = new Student("名字1",18);
		Student stu2 = new Student("名字2",18);
		List<Student> list = new ArrayList<>();
		list.add(stu);
		list.add(stu2);
		//将list转为json字符串
		Gson gson = new Gson();
		String json = gson.toJson(list);
		System.out.println(json);
		
		//json字符串转为list
		//List list2 = gson.fromJson(json, List.class);
		//gson 创建MyType类继承TypeToken类 写好泛型
		List<Student> list2 = gson.fromJson(json, new MyType().getType());
		System.out.println(list2);
	}

	@Test
	public void test4() {
		Map<String, Student> map = new HashMap<>();
		Student stu = new Student("名字1",18);
		Student stu2 = new Student("名字2",18);
		
		map.put("no1", stu);
		map.put("no2", stu2);
		
		//将map转为json字符串
		Gson gson = new Gson();
		String json = gson.toJson(map);
		System.out.println(json);
		
		//json字符串转为map
		//gson 创建MyType类/匿名对象类继承TypeToken类 写好泛型
		Map<String, Student> map2 = gson.fromJson(json, new TypeToken<Map<String, Student>>(){}.getType());
		System.out.println(map2);
		System.out.println(map2.get("no1").getName());
	}
	
}
