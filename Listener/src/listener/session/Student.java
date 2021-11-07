package listener.session;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 	监听student对象的钝化和活化
 *	对象要和session一起活化钝化必须实现序列化接口
 *	不需要在web.xml里配置
 */
public class Student implements HttpSessionActivationListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	
	public Student() {
	}

	public Student(String username) {
		super();
		this.username = username;
	}


	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		// session将钝化
		System.out.println("即将和session一起钝化");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// session被激活
		System.out.println("和session一起活化");
		HttpSession session = se.getSession();
		Object attribute = session.getAttribute("stu");
		System.out.println(attribute);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	@Override
	public String toString() {
		return "Student [username=" + username + "]";
	}
	

}
