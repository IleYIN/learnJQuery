package dao.impl;

import bean.User;
import dao.BaseDao;
import dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public User getUserByUserNameAndPassword(User user) {
		String sql = "select * from bs_user where username=? and password=?";
		User bean = this.getBean(sql, user.getUsername(), user.getPassword());
		return bean;
	}

	@Override
	public boolean registUser(User user) {
		String sql = "insert into bs_user(username,password,email) values (?,?,?)"
				+ "";
		int update = this.update(sql, user.getUsername(), user.getPassword(), user.getEmail());
		return update > 0;
	}

	@Override
	public User getUserByUserName(User user) {
		String sql = "select * from bs_user where username=?";
		return getBean(sql, user.getUsername());
	}

}
