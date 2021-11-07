package listener.session;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

	private String username;
	public User() {
	}
	public User(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// 此类的对象绑定到session中
		System.out.println("对象绑定在session中了...");
		//对象绑定在session中使用的key
		String name = event.getName();
		//绑定在session中的具体对象（监控的对象）
		Object value = event.getValue();
		System.out.println("key:"+name+",value:"+value);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// 此类的对象从session中移除
		System.out.println("对象从session中解除绑定...");
		String name = event.getName();
		Object value = event.getValue();
		System.out.println("key:"+name+",value:"+value);
		
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
	
}
