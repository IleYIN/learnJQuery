package service.impl;

import bean.User;
import dao.UserDao;
import dao.impl.UserDaoImpl;
import service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao ud = new UserDaoImpl();
	@Override
	public User login(User user) {
		return ud.getUserByUserNameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		return ud.registUser(user);
	}

	/**
	 *  true 可以注册
	 *  false 不可以，用户已存在
	 */
	@Override
	public boolean checkUser(User user) {
		return ud.getUserByUserName(user)==null;
	}

}
