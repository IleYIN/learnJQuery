package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		// TODO Auto-generated method stub
		//获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//判断用户是否登录成功 如果什么都没填会得到空串而不是null
		if(username.length() >= 6 && "123456".equals(password)) {
			//登录成功-->重定向
			response.sendRedirect("success/login-success.html");
		}else {
			//登录失败-->转发
			request.getRequestDispatcher("success/login-error.html").forward(request,response);
		}
		System.out.println(username+"-->"+password);
		
		
	}

}
