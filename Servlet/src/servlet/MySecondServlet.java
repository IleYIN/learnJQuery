package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * һ��Servletֻ�ܴ���һ��ָ��������
 * 
 * Ӧ��ָ��servlet�����Ǹ�����
 * ��Ҫ��web.xml��������servlet����ϸ��Ϣ
 *
 *
 * 1. �����Լ�������ʵ��servlet�ӿ�
 * 2. ��service��������д����
 * 3. ��web.xml������
 */
public class MySecondServlet implements Servlet {
//����Դ�����������add unimplemented method�����ͻ���ʾ
	
	//��ʼ��
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	//��ȡservlet������Ϣ
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// �����������Կͻ��˵�����
		System.out.println("second servlet");
		//ServletResponse res�����������һ����Ӧ
		PrintWriter writer = res.getWriter();
		writer.write("HelloServlet");
	}

	//��ȡservlet��Ϣ
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
