package service;

import bean.User;

/**
 * 	完成用户的登录注册
 * @author yinyiliang
 *
 */
public interface UserService {
	public User login(User user);
	public boolean regist(User user);
	public boolean checkUser(User user);
}
