package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
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
		//相对路径：相对当前资源的路径
		//转发使用相对路径可能导致一些问题
		
		//绝对路径：以/开始，代表的是项目的根目录(WebContent里的东西)，http://localhost:8080/Servlet
		//这和html里的/不同，见path.html
		//1. 转发可以使用绝对路径
//		request.getRequestDispatcher("pages/a.html").forward(request, response);
		request.getRequestDispatcher("/pages/a.html").forward(request, response);
//		request.getRequestDispatcher("/index.html").forward(request, response);
		
		//2. 重定向使用绝对路径 / tomcat的根目录（容器）服务器的根 http://localhost:8080
//		response.sendRedirect("/Servlet/pages/a.html");
		//	重定向 相当于让浏览器重新访问，浏览器去解析，所以根是服务器的根
		//  转发  相当于在服务器内部去解析，所以根是服务器项目名
		
		//项目的根 Properties -> Web Project Settings -> Context root
		//重定向和转发推荐使用绝对路径
		//重定向推荐动态获取项目的根目录，项目路径
		ServletContext context = getServletContext();
		String contextPath = context.getContextPath();
		System.out.println(contextPath);
//		response.sendRedirect(contextPath+"/pages/a.html");
		
		//或者推荐直接用request.getContextPath()
		String path2 = request.getContextPath();
		System.out.println(path2);
//		response.sendRedirect(path2+"/pages/a.html");
		
		//同名项目冲突问题：
		//Eclipse import project的时候 .project里面的name标签项目名判断是否该项目已经存在
	}

}
