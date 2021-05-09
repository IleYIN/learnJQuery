package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = WebUtils.param2bean(request, new User());
		
		boolean b = us.regist(user);
		if(b) {
			//注册成功 返回成功页面 重定向
			response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.html");
		} else {
			//注册失败 返回注册页面，重新注册 转发
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user2 = WebUtils.param2bean2(request, new User());
		//用户登录，用户的详情
		User user = us.login(user2);
		System.out.println(user);
		
		//将用户保存到session中
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
			//登录失败 返回登录页面即可 转发
			request.setAttribute("msg","用户名密码错误");
			//也可以设置上要回显的项目
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			//登录成功 放回成功页面 重定向
			//response.sendRedirect(request.getContextPath()+"/pages/user/login-success.html");
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success_menu.jsp");
		}
	}

}
