package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService us = new UserServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = us.login(new User(null, username, password, null));
		if(user.getUsername() == null || user.getUsername().isEmpty()) {
			//登录失败 返回登录页面即可 转发
//			request.getRequestDispatcher("/pages/user/login-error.html").forward(request, response);
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<h1>登录失败</h1>");
		} else {
			//登录成功 放回成功页面 重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/login-success.html");
		}
	}

}
