package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet
 */
public class EncodingServlet extends HttpServlet {
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
		//在第一次操作response之前，设置好内容类型和字符编码
		
		//方法1
		//告诉浏览器我传输的数据的内容类型
//		response.setContentType("text/html");
		//告诉浏览器编码
//		response.setCharacterEncoding("GBK");
		//注意设置编码要在获取流之前！！
		
		//方法2
		//直接设置响应头
//		response.addHeader("Content-Type", "text/html;charset=GBK");		

		//方法3-设置Content-Type字段
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("请求成功！");
		
		//字符乱码存在以下地方
		/**
		 * 1.响应给浏览器的数据是乱码
		 * 		原因：是李兰器不知道数据的类型及编码格式
		 * 		解决：告诉路蓝旗内容类型及编码格式。（响应头里Content-Type）
		 * 		方法：3种 response.setContentType("text/html;charset=UTF-8");	 */
		
	}
}
