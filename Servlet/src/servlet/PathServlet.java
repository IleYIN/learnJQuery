package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PathServlet
 */
public class PathServlet extends HttpServlet {
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
		//���·������Ե�ǰ��Դ��·��
		//ת��ʹ�����·�����ܵ���һЩ����
		
		//����·������/��ʼ�����������Ŀ�ĸ�Ŀ¼(WebContent��Ķ���)��http://localhost:8080/Servlet
		//���html���/��ͬ����path.html
		//1. ת������ʹ�þ���·��
//		request.getRequestDispatcher("pages/a.html").forward(request, response);
		request.getRequestDispatcher("/pages/a.html").forward(request, response);
//		request.getRequestDispatcher("/index.html").forward(request, response);
		
		//2. �ض���ʹ�þ���·�� / tomcat�ĸ�Ŀ¼���������������ĸ� http://localhost:8080
//		response.sendRedirect("/Servlet/pages/a.html");
		//	�ض��� �൱������������·��ʣ������ȥ���������Ը��Ƿ������ĸ�
		//  ת��  �൱���ڷ������ڲ�ȥ���������Ը��Ƿ�������Ŀ��
		
		//��Ŀ�ĸ� Properties -> Web Project Settings -> Context root
		//�ض����ת���Ƽ�ʹ�þ���·��
		//�ض����Ƽ���̬��ȡ��Ŀ�ĸ�Ŀ¼����Ŀ·��
		ServletContext context = getServletContext();
		String contextPath = context.getContextPath();
		System.out.println(contextPath);
//		response.sendRedirect(contextPath+"/pages/a.html");
		
		//�����Ƽ�ֱ����request.getContextPath()
		String path2 = request.getContextPath();
		System.out.println(path2);
//		response.sendRedirect(path2+"/pages/a.html");
		
		//ͬ����Ŀ��ͻ���⣺
		//Eclipse import project��ʱ�� .project�����name��ǩ��Ŀ���ж��Ƿ����Ŀ�Ѿ�����
	}

}
