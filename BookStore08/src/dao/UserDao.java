package dao;

import bean.User;

/*
 * public class UserDao extends BaseDao<User>{
 * 
 * }
 */
public interface UserDao{
	/**
	 * 	�����û��������ѯ��ϸ��Ϣ
	 * @param user
	 * @return
	 */
	public User getUserByUserNameAndPassword(User user);
	
	/**
	 * 	ע�ᣬ�����û�
	 * @param user
	 * @return
	 */
	public boolean registUser(User user);
	
	public User getUserByUserName(User user);
};