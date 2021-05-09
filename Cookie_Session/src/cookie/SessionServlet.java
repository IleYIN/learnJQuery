package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//判断session是否是新创建的
		boolean isNew = session.isNew();
		//表示我这个session的唯一标识
		String id = session.getId();
		response.getWriter().write("已获取到session对象,是否为新的？"+isNew+",id:"+session.getId());
	}
	
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//给session域中保存数据
		session.setAttribute("username", "namevalue");
		response.getWriter().write("session中保存了数据");
	}
	
	protected void getvalue(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		String attribute = (String) session.getAttribute("username");
		response.getWriter().write("session对象中的数据："+attribute);
	}

	protected void time(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//获取session的最大存活时间 秒
		//session默认是30分钟
		//为什么新会话开启会返回新session？
		//因为获取session根据cookie带来的jsessionid来获取，cookie默认关闭浏览器就没了
		//所以再来获取session时，服务器会犯规新的session，旧的session还在只是找不到了
		int interval = session.getMaxInactiveInterval();
		response.getWriter().write("session存活时间："+interval);
	}
	
	protected void updatetime(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//传入负数：永不过期
		//传入正数：代表多少秒后过期，指距离最后一次使用session的时间
		session.setMaxInactiveInterval(3);
		response.getWriter().write("session将于3秒后过期");
	}

	protected void invalid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session对象
		HttpSession session = request.getSession();
		//使session立即失效
		session.invalidate();
		response.getWriter().write("session已经失效");
	}
	
	protected void persist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//浏览器关闭也可以保持session，下次访问还能访问到之前的session
		HttpSession session = request.getSession();
		//将jsessionid这个cookie持久化 jsessionid=xxxxxxx
		String id = session.getId();
		Cookie cookie = new Cookie("JSESSIONID", id);
		//设置cookie的持久时间 秒
		cookie.setMaxAge(60*60);
		response.addCookie(cookie);
		response.getWriter().write("session已保持");
	}
}
