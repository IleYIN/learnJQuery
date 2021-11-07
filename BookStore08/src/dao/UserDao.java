package dao;

import bean.User;

/*
 * public class UserDao extends BaseDao<User>{
 * 
 * }
 */
public interface UserDao{
	/**
	 * 	按照用户名密码查询详细信息
	 * @param user
	 * @return
	 */
	public User getUserByUserNameAndPassword(User user);
	
	/**
	 * 	注册，保存用户
	 * @param user
	 * @return
	 */
	public boolean registUser(User user);
	
	public User getUserByUserName(User user);
};