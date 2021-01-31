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
		
		//��ȡ�û���д����Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repwd = request.getParameter("repwd");
		String email = request.getParameter("email");
		
		System.out.println(username+"-->"+password+"-->"+repwd+"-->"+email);
		
		//�ж��û��Ƿ����ע��
		if(!"admin".equals(username)) {
			request.getRequestDispatcher("success/regist-success.html").forward(request, response);
		} else {
			response.sendRedirect("success/regist-error.html");
		}
	}
	//��̬��Ŀ���̵���ʱ��ע��configure build pathȷ��java��tomacat����unbound���Լ�Project Facets�����Runtime���tomcat
}
