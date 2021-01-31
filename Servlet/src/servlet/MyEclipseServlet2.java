package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet2
 */
public class MyEclipseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpServletRequest request代表浏览器发送给服务器的请求信息
		//http请求：请求首行 请求头 空行 请求体（封装的请求数据-post）
		//get请求将所有要携带的参数放在url
		
		//作用：
		//1. 获取请求数据， get放在url后面，post放在请求体里
		String username = request.getParameter("username");
		//使用getParameterValues获取多选框的内容
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(username+"--"+hobby);
		if(hobby!=null) {
			for(String s : hobby) {
				System.out.println(s);
			}
		}
		
		//2. 获取请求头
		String userAgent = request.getHeader("User-Agent");
		System.out.println("请求头中User-Agent:"+userAgent);
		
		//3. 转发一个页面/资源
		//获取请求转发器
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
		//将请求转发出去
		requestDispatcher.forward(request, response);
		//相比于重定向response.sendRedirect("success.html");
		//重定向请求了两次(MyEclipseServlet和success.html)，地址变了，response是302
		//而转发请求requestDispatcher.forward(request, response);
		//只请求了一次(MyEclipseServlet2),地址没变 response是200
		
		//4. 作为域对象共享数据 4个域对象：ServletContext是application；request
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
