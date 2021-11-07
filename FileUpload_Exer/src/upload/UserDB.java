package upload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDB {
	
	private static Map<String, User> map = new HashMap<>();
	
	public static void save(User user) {
		map.put(user.getUsername(), user);
	}
	
	/**
	 * 所有用户
	 * @return
	 */
	public static List<User> getAll(){
		return new ArrayList<>(map.values());
	}
}
