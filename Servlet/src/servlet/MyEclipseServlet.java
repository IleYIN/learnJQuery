package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet
 * 
 * HttpServlet专门为处理Http请求定制的Servlet web应用
 * 
 */
public class MyEclipseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet() {
        super();
        System.out.println("constructer...");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * doGet用来处理get请求方式
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//每次请求调用doGet方法
		//正常来讲里那个方法不区分，可以写一个，然后另一个调用，如doPost调用doGet
		System.out.println("doGet..");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *  doPost处理post请求
	 *  
	 *  post目前就只有一种：表单提交的时候指定method="post"
	 *   回车，超链接，img，src="图片路径"等都是get请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpServletRequest request，HttpServletResponse response由服务器创建
		//HttpServletRequest request代表的就是封装浏览器请求信息的对象，收到的浏览器端的请求
		//HttpServletResponse response代表的就是要发送浏览器的响应对象，封装响应信息。
		
		//一个请求对应一个响应
		//作用：1.可以给浏览器响应字符串
//		PrintWriter writer = response.getWriter();
//		writer.write("hello httpservlet....");

		response.sendRedirect("success.html");
		String username = request.getParameter("username");
		System.out.println(username);
		
		//一个请求对应一个响应,提交响应后无法转发
		request.getRequestDispatcher("success.html").forward(request, response);
		
		//2.可以重定向到一个页面或者其他资源，重新请求别的资源
		//我的处理代码...已经对之前的request响应完了
		
		
		System.out.println("doPost..");
		doGet(request, response);
	}

}
