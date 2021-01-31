package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet3
 */
public class MyEclipseServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		//经过MyEclipseServlet3处理后，获取请求头信息，在控制台打印
		String header = request.getHeader("User-Agent");
		//request.getHeaders("请求头")
		System.out.println("用户浏览器信息："+header);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//返回success.html页面，只能响应一个
		//1. 重定向页面  就是告诉浏览器重新请求一个资源（静态或者动态）
		// http://localhost:8080/Servlet/success.html
		// http://localhost:8080/Servlet/MyEclipseServlet3
//		response.sendRedirect("success.html");
		//找和MyEclipseServlet同级目录下的资源
//		response.sendRedirect("pages/success2.html");
		
		//2. 转发到页面
		//转发：服务器处理完成以后转交到另外一个资源
		//当我们转发的资源是一个页面资源（静态资源），
		//服务器会给浏览器返回这个资源
		//当是动态资源，如转交给下一个servlet，servlet可以继续处理
		//直到最后一个servlet完成响应
		
		//获取转发器，forward转发
		//request.getRequestDispatcher("pages/success2.html").forward(request, response);
		
		/**
		 * 转发和重定向的区别：见截图
		 */
		//response.sendRedirect("WEB-INF/success3.html");
		//重定向:404 源服务器未能找到目标资源的表示或者是不愿公开一个已经存在的资源表示
		//request.getRequestDispatcher("WEB-INF/success3.html").forward(request, response);
		//转发：可以访问受保护的 WEB-INF, 服务器内部完成
		//response.sendRedirect("http://www.baidu.com");
		//重定向可以访问外部资源，转发只能访问内部资源
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
	}

}
