package cookie;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("username", "namevalue");
		Cookie cookie2 = new Cookie("password", "passwordvalue");
		response.addCookie(cookie);
		response.addCookie(cookie2);
		response.getWriter().write("发送cookie");
	}

	protected void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			//遍历cookie键值对
			for(Cookie cookie:cookies) {
				String name = cookie.getName();
				String value = cookie.getValue();
				response.getWriter().write("<br>cookie的name："+name);
				response.getWriter().write("<br>cookie的value："+value);
			}
		}
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookietodel = null;
		//遍历cookie键值对
		if(cookies != null) {
			for(Cookie cookie:cookies) {
				String name = cookie.getName();
				if("username".equals(name)) {
					cookietodel = cookie;
					//负数 不保存cookie 即使发给浏览器也不会保存
					//正数 cookie的最大存在时间 秒
					//0 表示删除cookie
					cookietodel.setMaxAge(0);
					//告诉浏览器
					response.addCookie(cookie);
					response.getWriter().write("<br>删除cookie其name为：username");
				}
			}
		}
	}
	
	protected void persist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		Cookie cookietodel = null;
		//遍历cookie键值对
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				String name = cookie.getName();
				if("username".equals(name)) {
					cookietodel = cookie;
					//负数 不保存cookie 即使发给浏览器也不会保存
					//正数 cookie的最大存在时间 秒
					//0 表示删除cookie
					cookietodel.setMaxAge(60*60);
					//告诉浏览器
					response.addCookie(cookie);
					response.getWriter().write("<br>cookie存活时间为1小时，其name为：username");
				}
			}
		}
	}
	
	//设置一个不保存的cookie 但是不同浏览器有自己的标准，cookie可能依然会在会话期间保存
	protected void unsave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("unsavekey", "unsavevalue");
		cookie.setMaxAge(-100);
		response.addCookie(cookie);
		response.getWriter().write("发送cookie");
	}
	
	//为cookie设置路径
	protected void setpath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("cookiename", "cookievalue");
		// "/"表示服务器的根，而不是项目的根
		// 告诉浏览器访问哪些路径带上此cookie
		cookie.setPath("/hello");//http://localhost:8080/hello下的所有东西都带上此cookie
		//默认访问当前项目下的所有资源都会携带
		response.addCookie(cookie);
		response.getWriter().write("cookie路径修改了");
	}
	//修改cookie 
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Cookie[] cookies = request.getCookies();
//		Cookie c = null;
//		//遍历cookie键值对
//		if(cookies!=null) {
//			for(Cookie cookie:cookies) {
//				String name = cookie.getName();
//				if("username".equals(name)) {
//					c = cookie;
//					break;
//				}
//			}
//			//告诉浏览器
//			c.setValue("newnamevalue");
//			response.addCookie(c);
//			response.getWriter().write("cookie已经修改，其name为：username");
//		}
		Cookie cookie = new Cookie("username", "newnamevalue");
		response.addCookie(cookie);
		response.getWriter().write("cookie已经修改，其name为：username");
	}
}
