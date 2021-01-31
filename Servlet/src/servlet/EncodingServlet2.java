package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet2
 */
public class EncodingServlet2 extends HttpServlet {
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
		//当我们在表单中填写中文的时候获取到的也是乱码
		//1. post 乱码原因：
		//	浏览器将请求体数据编码并提交上来，但是服务器并不知道编码规则
		//解决方法：让服务器知道编码规则,重新设置请求体的编码格式
		//request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
		
		//2. get 乱码  
		// 原因：浏览器将地址栏url也编码，服务器不知道编码规则，而端口接收到的url是已经按照默认的方式解码了
		// 数据在url请求地址里而不是请求体里，request.setCharacterEncoding("UTF-8")对url没有作用
		// 解决方法：在tomcat的server.xml里的connector里，设置URIEncoding="UTF-8"
		// 另外，UseBodyEncodingForURI(默认是false)，是指是否使用请求体的编码方式来解码url
		
		//解决响应乱码
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("请求成功");
	}

}
