package test;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import bean.User;

public class BeanUtilsTest {

	@Test
	public void test1() {
		//BeanUtils.setProperty(bean, name, value);
		//bean: Ҫ���ĸ�������������ֵ
		//name: Ҫ���õ�������
		//value: Ҫ���õ�ֵ
		User user = new User();
		System.out.println("1:"+user);
		try {
			BeanUtils.setProperty(user, "username", "С��");
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
			BeanUtils.setProperty(student, "age", "���Ե����Ͳ��ḳֵ");
			System.out.println("2:"+student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//javaBean ����
	//getter setter�����е����ֲ���javaBean���������������������ı�����
	//getImgPath --> imgPath
	
}
