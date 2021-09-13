package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService us = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = WebUtils.param2bean(request, new User());
		
		boolean b = us.regist(new User(null, username, password, email));
		if(b) {
			//ע��ɹ� ���سɹ�ҳ�� �ض���
			response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.jsp");
		} else {
			//ע��ʧ�� ����ע��ҳ�棬����ע�� ת��
			//request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			
			request.setAttribute("msg", "�û��Ѵ���");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
