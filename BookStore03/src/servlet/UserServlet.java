package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//�����û����� login register
//		/**
//		 * if(��¼����)
//		 * {
//		 * 	�����û���¼
//		 * } else if(ע������)
//		 * {
//		 * 	�����û�ע��
//		 * } else if(�޸�����)
//		 * {
//		 * 	�����޸�����
//		 * }
//		 *	����Ϊpost�������һ��method�ֶΣ��ύ��ʱ�򣬴���methodֵ
//		 * 	ע�⣺get���󣬱������ݻᱻ���ϣ���֮ǰ�����ַ�е����ݻᱻ�����ݸ���
//		 * 		��ʱ��Ҫ���һ�������������ݻᱻ�ύ��
//		 * 
//		 * 	Ϊ�˱����ظ��жϣ������÷��������
//		 * 	���е�servlet����ͨ��������������Ӧ�ķ������������ǿ��Գ�ȡ��һ��BaseServlet
//		 */
//		String method = request.getParameter("method");
//		//System.out.println(method);
////		if("regist".equals(method)) {
////			//ע������
////			regist(request, response);
////		
////		} else if("login".equals(method)) {
////			//��¼����
////			login(request, response);
////		}
//		try {
//			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
//			method2.setAccessible(true);
//			//invoke(���󣬲���);
//			method2.invoke(this, request, response);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		String email = request.getParameter("email");
		User user = WebUtils.param2bean(request, new User());
		
//		boolean b = us.regist(new User(null, username, password, email));
		boolean b = us.regist(user);
		if(b) {
			//ע��ɹ� ���سɹ�ҳ�� �ض���
			response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.html");
		} else {
			//ע��ʧ�� ����ע��ҳ�棬����ע�� ת��
			//request.getRequestDispatcher("/pages/user/regist.html").forward(request, response);
			
			request.setAttribute("msg", "�û��Ѵ���");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		User user = us.login(new User(null, username, password, null));
		User user2 = WebUtils.param2bean2(request, new User());
		User user = us.login(user2);
		
		if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
			//��¼ʧ�� ���ص�¼ҳ�漴�� ת��
			//request.getRequestDispatcher("/pages/user/login-error.html").forward(request, response);
			//response.setContentType("text/html;charset=utf-8");
			//response.getWriter().write("<h1>��¼ʧ��</h1>");
			
			request.setAttribute("msg","�û����������");
			//Ҳ����������Ҫ���Ե���Ŀ
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			//��¼�ɹ� �Żسɹ�ҳ�� �ض���
			response.sendRedirect(request.getContextPath()+"/pages/user/login-success.html");
		}
	}

}
