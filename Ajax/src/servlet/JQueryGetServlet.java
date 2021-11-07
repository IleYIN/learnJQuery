package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JQueryGetServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	protected void getUrlParam(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student stu = new Student("名字", 25);
		Gson gson = new Gson();
		String json = gson.toJson(stu);
		response.getWriter().write(json);
	}

	protected void getUrlData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从请求的数据中获取学生信息
		System.out.println("getUrlData--");
		String stuName = request.getParameter("name");
		String stuAge = request.getParameter("age");
		System.out.println(stuName+"--"+stuAge);
		Student stu = new Student(stuName, Integer.parseInt(stuAge));
		Gson gson = new Gson();
		String json = gson.toJson(stu);
		response.getWriter().write(json);
	}

}
