package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ContextServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletConfig servletConfig = this.getServletConfig();
		ServletContext servletContext = servletConfig.getServletContext();
		
		//ServletContext����
		//һ��webӦ�ö�Ӧһ��ServletContext,��������web��Ŀ
		//���ܣ�
		//1.���Ի�ȡweb��Ŀ��������Ϣ����ȡweb��Ŀ�ĳ�ʼ������
		String user = servletContext.getInitParameter("user");
		String username = servletContext.getInitParameter("username");
		//System.out.println(user+"-->"+username);
		//2.��ȡweb����Ŀ·�� ����·��
		String path = servletContext.getContextPath();
		System.out.println(path);
		//3.��ȡ��Դ����ʵ·��
		//����·�����������ʹ�õ�·������Ӧһ��ʵ�ʵ���Դ
		//��̬��Դ���ļ�����ʽ������̬��Դ��ֻ������һ�γ�����룩
		//url(����·��)->DNS->server->ĳ����Ŀ->��Դ(��ʵ·��)
		//��ʵ·�������ļ������еĴ洢·�� 
		String realPath = servletContext.getRealPath("/index.html");
		System.out.println(realPath);
		//getRealPath("��Դ��web��Ŀ�µ�����·��")
		//�ȿ��Ի�ȡ���ڵ���Դ����ʵ·��ͨ�����������д��Ҳ���Ի�ȡδ���ڵ���Դͨ������������д
		//4.������Ϊ���������������   ����󣺹�������
		//�Ĵ������pageContext,request,session,application��֮һ��application�����
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
