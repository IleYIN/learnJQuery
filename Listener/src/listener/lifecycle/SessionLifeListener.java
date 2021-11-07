package listener.lifecycle;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionLifeListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("session对象创建...");
		//se获取创建session
		HttpSession session = se.getSession();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session对象销毁...");
	}

}
