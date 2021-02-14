package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListStudentServlet
 */
@WebServlet("/list")
public class ListStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//应该查出所有学生数据
		List<Student> list = new ArrayList<Student>();
		list.add(new Student(1, "小明", "男", "一年级", new Date()));
		list.add(new Student(2, "小一", "男", "一年级", new Date()));
		list.add(new Student(3, "小二", "女", "二年级", new Date()));
		list.add(new Student(4, "小三", "男", "一年级", new Date()));
		list.add(new Student(5, "小四", "女", "四年级", new Date()));
		list.add(new Student(6, "小五", "男", "一年级", new Date()));
		
		//能用小的域对象就用小的域对象，把数据放在request域中
		request.setAttribute("list",list);
		//转发到页面
		//request.getRequestDispatcher("/list.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/list2.jsp").forward(request, response);
		//如果.jsp文件在web-inf文件夹里面，直接访问.jsp会出现404错误，因为其中的文件受保护，只能通过链接来访问
		
	}

}
