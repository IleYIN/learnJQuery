package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import bean.User;

public class BeanUtilsTest {

	@Test
	public void test1() {
		//BeanUtils.setProperty(bean, name, value);
		//bean: 要给哪个对象设置属性值
		//name: 要设置的属性名
		//value: 要设置的值
		User user = new User();
		System.out.println("1:"+user);
		try {
			BeanUtils.setProperty(user, "username", "小明");
			System.out.println("2:"+user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		Student student = new Student();
		System.out.println("1:"+student);
		try {
//			BeanUtils.setProperty(student, "age", 12);
//			BeanUtils.setProperty(student, "age", "12");
			BeanUtils.setProperty(student, "age", "不对的类型不会赋值");
			System.out.println("2:"+student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//javaBean 属性
	//getter setter方法中的名字才是javaBean的属性名，而不是声明的变量名
	//getImgPath --> imgPath
	
}
