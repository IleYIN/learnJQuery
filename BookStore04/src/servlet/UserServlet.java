package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class UserServlet
 * 
 * 	抽取出BaseServlet后，UserServlet只需要编写相应的处理逻辑即可
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	//方法名(request,response)
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//处理用户请求 login register
//		/**
//		 * if(登录请求)
//		 * {
//		 * 	调用用户登录
//		 * } else if(注册请求)
//		 * {
//		 * 	调用用户注册
//		 * } else if(修改密码)
//		 * {
//		 * 	调用修改密码
//		 * }
//		 *	可以为post请求添加一个method字段，提交的时候，带上method值
//		 * 	注意：get请求，表单的数据会被带上，而之前请求地址中的数据会被表单数据覆盖
//		 * 		这时需要添加一个表单项，表单项的数据会被提交上
//		 * 
//		 * 	为了避免重复判断，可以用反射来解决
//		 * 	所有的servlet都是通过反射来调用相应的方法，所以我们可以抽取出一个BaseServlet
//		 */
//		String method = request.getParameter("method");
//		//System.out.println(method);
////		if("regist".equals(method)) {
////			//注册请求
////			regist(request, response);
////		
////		} else if("login".equals(method)) {
////			//登录请求
////			login(request, response);
////		}
//		try {
//			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
//			method2.setAccessible(true);
//			//invoke(对象，参数);
//			method2.invoke(this, request, response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
		User user = WebUtils.param2bean(request, new User());
		
//		boolean b = us.regist(new User(null, username, password, email));
		boolean b = us.regist(user);
		if(b) {
			//注册成功 返回成功页面 重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.html");
		} else {
			//注册失败 返回注册页面，重新注册 转发
			//request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		User user = us.login(new User(null, username, password, null));
		User user2 = WebUtils.param2bean2(request, new User());
		User user = us.login(user2);
		
		if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
			//登录失败 返回登录页面即可 转发
			//request.getRequestDispatcher("/pages/user/login-error.html").forward(request, response);
			//response.setContentType("text/html;charset=utf-8");
			//response.getWriter().write("<h1>登录失败</h1>");
			
			request.setAttribute("msg","用户名密码错误");
			//也可以设置上要回显的项目
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			//登录成功 放回成功页面 重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/login-success.html");
		}
	}

}
