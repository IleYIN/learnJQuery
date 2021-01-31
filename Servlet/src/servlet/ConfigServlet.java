package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigServlet implements Servlet {

	private ServletConfig config = null;
	/**
	 * ��ʼ�������ڴ���ʱ������һ��
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//ServletConfig�Ƿ�װ�˵�ǰServlet������Ϣ�Ķ���
		//һ��Servlet�����Ӧһ��ServletConfig
		this.config = config;
		//���ܣ�1.��ȡservlet�ı���
		String servletName = config.getServletName();
		System.out.println(servletName);
		//2.��ȡservlet��ʼ������
		String username = config.getInitParameter("username");
		System.out.println("��ʼ������:username->"+username);
		//3.��ȡServletContext����
		//ServletContext����ǰservlet�������ģ������ҵ�ǰ��web��Ŀ��Ϣ
		//һ��web��Ŀ��Ӧһ��ServletContext
		//ServletContext-->�͹ݾ���   Servlet-->�͹ݷ���Ա
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);
		
	}
	
	/**
	 * 	��ȡservlet��������Ϣ
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * ����servlet��������Ϣ
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����servlet����
	 * ������ֹͣ����ж����Ŀʱ����
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
