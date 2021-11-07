package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class AJAXServlet
 */
public class AJAXServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("收到请求了...");
		response.setContentType("text/html;charset=utf-8");
		Date date = new Date();
		String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		response.getWriter().write(format);
		Student stu = new Student("名字",18);

		Gson gson = new Gson();
		String json = gson.toJson(stu);
		response.getWriter().write(json);
	}

}
