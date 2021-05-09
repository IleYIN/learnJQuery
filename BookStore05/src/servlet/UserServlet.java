package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class UserServlet
 * 
 * 	��ȡ��BaseServlet��UserServletֻ��Ҫ��д��Ӧ�Ĵ����߼�����
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	//������(request,response)
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = WebUtils.param2bean(request, new User());
		
		boolean b = us.regist(user);
		if(b) {
			//ע��ɹ� ���سɹ�ҳ�� �ض���
			response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.html");
		} else {
			//ע��ʧ�� ����ע��ҳ�棬����ע�� ת��
			request.setAttribute("msg", "�û��Ѵ���");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user2 = WebUtils.param2bean2(request, new User());
		//�û���¼���û�������
		User user = us.login(user2);
		System.out.println(user);
		
		//���û����浽session��
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
			//��¼ʧ�� ���ص�¼ҳ�漴�� ת��
			request.setAttribute("msg","�û����������");
			//Ҳ����������Ҫ���Ե���Ŀ
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			//��¼�ɹ� �Żسɹ�ҳ�� �ض���
			//response.sendRedirect(request.getContextPath()+"/pages/user/login-success.html");
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success_menu.jsp");
		}
	}

}
