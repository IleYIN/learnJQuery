package service;

import bean.User;

/**
 * 	����û��ĵ�¼ע��
 * @author yinyiliang
 *
 */
public interface UserService {
	public User login(User user);
	public boolean regist(User user);
	public boolean checkUser(User user);
}
