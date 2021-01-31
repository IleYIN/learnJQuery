package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet2
 */
public class EncodingServlet2 extends HttpServlet {
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
		//�������ڱ�����д���ĵ�ʱ���ȡ����Ҳ������
		//1. post ����ԭ��
		//	����������������ݱ��벢�ύ���������Ƿ���������֪���������
		//����������÷�����֪���������,��������������ı����ʽ
		//request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		System.out.println(username);
		
		//2. get ����  
		// ԭ�����������ַ��urlҲ���룬��������֪��������򣬶��˿ڽ��յ���url���Ѿ�����Ĭ�ϵķ�ʽ������
		// ������url�����ַ��������������request.setCharacterEncoding("UTF-8")��urlû������
		// �����������tomcat��server.xml���connector�����URIEncoding="UTF-8"
		// ���⣬UseBodyEncodingForURI(Ĭ����false)����ָ�Ƿ�ʹ��������ı��뷽ʽ������url
		
		//�����Ӧ����
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("����ɹ�");
	}

}
