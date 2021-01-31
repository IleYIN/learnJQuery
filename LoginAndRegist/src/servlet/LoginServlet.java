package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡ�û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//�ж��û��Ƿ��¼�ɹ� ���ʲô��û���õ��մ�������null
		if(username.length() >= 6 && "123456".equals(password)) {
			//��¼�ɹ�-->�ض���
			response.sendRedirect("success/login-success.html");
		}else {
			//��¼ʧ��-->ת��
			request.getRequestDispatcher("success/login-error.html").forward(request,response);
		}
		System.out.println(username+"-->"+password);
		
		
	}

}
