package servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;

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
		//��ȡ�û��������֤�룬��ȡsession�е���֤��
		String code = request.getParameter("code");//ҳ���е���֤��
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("ҳ�����֤�룺"+code);
		System.out.println("session�е���֤�룺"+sessionCode);
		
		//�����֤�벻һ�£���ص�ע��ҳ�沢��ʾ��֤�����
		if(!sessionCode.equals(code)) {
			request.setAttribute("msg", "��֤�����");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			return;
		}
		
		User user = WebUtils.param2bean(request, new User());
		
		boolean b = us.regist(user);
		if(b) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//ҳ���ύʱ���һ������
			//��servlet��Ӧ����һ��һģһ�������ƣ�����ÿ���ύ�������ݻ�������ƣ�
			//������������֤�ͱ��ص������Ƿ�һ��
			//HttpSession session = request.getSession();
			//��������session��ȡ��������
			String token = (String)session.getAttribute("token");
			System.out.println("sessionToken:"+token);
			//�������session�е�����token�ı���Ƴ���
			//�������˲����ӻ����еõ���token��session�е�token��һ��
			session.removeAttribute("token");
			
			//ҳ����ȡ�����ƽ��ж���
			String pageToken = request.getParameter("token");
			System.out.println("pageToken:"+pageToken);
			if(pageToken == null) {
				pageToken = "";
			}
			
			if(pageToken.equals(token)) {
				//ע��ɹ� ���سɹ�ҳ�� �ض���
				response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.jsp");
				//request.getRequestDispatcher("/pages/user/regist-success.jsp").forward(request, response);
			}  else {
				response.sendRedirect(request.getContextPath() + "/pages/user/regist-error.jsp");
			}
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
		//System.out.println(user);
		
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
			response.sendRedirect(request.getContextPath()+"/pages/user/login-success.jsp");
		}
	}

	/**
	 * 	�û��ǳ�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//����session����
		session.invalidate();
		//����ǳ������̳���ҳ
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * 	��������Ƿ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ҳ��Ӧ�ð��û��������� keyӦ����username
		// ҳ�洫����user����
		User user = WebUtils.param2bean(request, new User());
		// ����û��Ƿ����
		boolean b = us.checkUser(user);
		if(b) {
			//����ע�ᣬд���ݾ��Ǹ��ͻ�����Ӧ
			response.getWriter().write("�û�������");
		} else {
			//������ע��
			response.getWriter().write("�û��Ѵ���");
		}
	}
}
