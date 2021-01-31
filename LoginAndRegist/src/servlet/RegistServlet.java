package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获取用户填写的信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repwd = request.getParameter("repwd");
		String email = request.getParameter("email");
		
		System.out.println(username+"-->"+password+"-->"+repwd+"-->"+email);
		
		//判断用户是否可以注册
		if(!"admin".equals(username)) {
			request.getRequestDispatcher("success/regist-success.html").forward(request, response);
		} else {
			response.sendRedirect("success/regist-error.html");
		}
	}
	//动态项目工程导入时，注意configure build path确认java和tomacat不是unbound，以及Project Facets里面的Runtime里的tomcat
}
