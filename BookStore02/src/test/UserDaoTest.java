package test;

import org.junit.Test;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;

public class UserDaoTest {
	@Test
	public void test() {
		UserDao ud = new UserDaoImpl();
		User user = ud.getUserByUserNameAndPassword(new User(null,"tomcat","123456",null));
		System.out.println(user);
	}

	@Test
	public void test2() {
		UserDao ud = new UserDaoImpl();
		Boolean b = ud.registUser(new User(null,"tomcat2","123456",null));
		System.out.println(b);
	}
}
