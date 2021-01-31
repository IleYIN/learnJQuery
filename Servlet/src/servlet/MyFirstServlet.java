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
 * 
 * 
 * Servlet����������:�Ӵ��������ٵĹ���
 * 
 * Servlet������Tomcat�������ϵ�
 * Tomcat������--->Servlet����
 * 
 * �����ǵ�һ�η���HelloServletʱ��
 * 1.����������һ��Servlet���� 
 * 2.����init������ʼ��servlet
 * 3.����service������������
 * �Ժ�����
 * 4.ֻ����service������������
 * 	���������ڼ�ֻ������һ��servlet����
 * ����ʵ�����̣߳�servlet��һ�㲻д��������������̰߳�ȫ����
 * ����Ŀ�ӷ�������ж�أ�
 * 5.�����������destroy���� ���ٷ����������ƺ�
 * 
 * 
 * 
 * 
 * web.xml
 *  <servlet>��servlet��ǩ����servlet������Ϣ + ���߷������������servlet
  	<servlet-name>����servlet������ �൱��MyFirstServlet�ı���
  	 <servlet-class>����servlet���ȫ�� ��������������������ͨ��ȫ�����ҵ�MyFirstServlet
  <servlet-mapping>servletӳ����Ϣ Ҳ����servlet����������һ������ 
  <servlet-name> �ղ����õ�MyFirstServlet��ı���
 	<url-pattern>���߷��������servlet���������ĸ�����  http://localhost:8080/Servlet/helloWorld 
 	 ���ʵ�ǰ��Ŀ�µĶ�̬��Դ/helloWorld��û���ҵ������̬��Դʱ��,���������󶨵�servlet����
  	ִ��index.html run on server
  	�û����������ַ������http://localhost:8080/Servlet/helloWorld
  	���������Ƿ��о�̬��Դ��Ӧ��û����Ӧ�ľ�̬��Դ���������ȥ�Ҷ�̬��Դurl-pattern
  	�����ҵ���Ӧ�󶨵�servlet�ಢִ�д���service����
  	
  	ʹ��eclipseֱ�Ӵ���servlet�����Զ�������ر�ǩ��web.xml��
 * 
 * 
 */
public class MyFirstServlet implements Servlet {
//����Դ�����������add unimplemented method�����ͻ���ʾ
	
	public MyFirstServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("MyFirstServlet()");
	}
	//��ʼ��
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()");
	}

	//��ȡservlet������Ϣ
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig()");
		return null;
	}

	//����
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service()");
		// �����������Կͻ��˵�����
		System.out.println("first servlet");
		//ServletResponse res�����������һ����Ӧ
		PrintWriter writer = res.getWriter();
		writer.write("HelloWorld");
	}

	//��ȡservlet��Ϣ
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()");
		// TODO Auto-generated method stub
		return null;
	}

	//����
	@Override
	public void destroy() {
		System.out.println("destroy()");
		// TODO Auto-generated method stub
		
	}

}
