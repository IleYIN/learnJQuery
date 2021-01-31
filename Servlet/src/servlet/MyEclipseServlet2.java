package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet2
 */
public class MyEclipseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpServletRequest request������������͸���������������Ϣ
		//http������������ ����ͷ ���� �����壨��װ����������-post��
		//get��������ҪЯ���Ĳ�������url
		
		//���ã�
		//1. ��ȡ�������ݣ� get����url���棬post������������
		String username = request.getParameter("username");
		//ʹ��getParameterValues��ȡ��ѡ�������
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(username+"--"+hobby);
		if(hobby!=null) {
			for(String s : hobby) {
				System.out.println(s);
			}
		}
		
		//2. ��ȡ����ͷ
		String userAgent = request.getHeader("User-Agent");
		System.out.println("����ͷ��User-Agent:"+userAgent);
		
		//3. ת��һ��ҳ��/��Դ
		//��ȡ����ת����
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.html");
		//������ת����ȥ
		requestDispatcher.forward(request, response);
		//������ض���response.sendRedirect("success.html");
		//�ض�������������(MyEclipseServlet��success.html)����ַ���ˣ�response��302
		//��ת������requestDispatcher.forward(request, response);
		//ֻ������һ��(MyEclipseServlet2),��ַû�� response��200
		
		//4. ��Ϊ����������� 4�������ServletContext��application��request
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
