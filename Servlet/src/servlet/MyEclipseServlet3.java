package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet3
 */
public class MyEclipseServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		//����MyEclipseServlet3����󣬻�ȡ����ͷ��Ϣ���ڿ���̨��ӡ
		String header = request.getHeader("User-Agent");
		//request.getHeaders("����ͷ")
		System.out.println("�û��������Ϣ��"+header);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//����success.htmlҳ�棬ֻ����Ӧһ��
		//1. �ض���ҳ��  ���Ǹ����������������һ����Դ����̬���߶�̬��
		// http://localhost:8080/Servlet/success.html
		// http://localhost:8080/Servlet/MyEclipseServlet3
//		response.sendRedirect("success.html");
		//�Һ�MyEclipseServletͬ��Ŀ¼�µ���Դ
//		response.sendRedirect("pages/success2.html");
		
		//2. ת����ҳ��
		//ת������������������Ժ�ת��������һ����Դ
		//������ת������Դ��һ��ҳ����Դ����̬��Դ����
		//�����������������������Դ
		//���Ƕ�̬��Դ����ת������һ��servlet��servlet���Լ�������
		//ֱ�����һ��servlet�����Ӧ
		
		//��ȡת������forwardת��
		//request.getRequestDispatcher("pages/success2.html").forward(request, response);
		
		/**
		 * ת�����ض�������𣺼���ͼ
		 */
		//response.sendRedirect("WEB-INF/success3.html");
		//�ض���:404 Դ������δ���ҵ�Ŀ����Դ�ı�ʾ�����ǲ�Ը����һ���Ѿ����ڵ���Դ��ʾ
		//request.getRequestDispatcher("WEB-INF/success3.html").forward(request, response);
		//ת�������Է����ܱ����� WEB-INF, �������ڲ����
		//response.sendRedirect("http://www.baidu.com");
		//�ض�����Է����ⲿ��Դ��ת��ֻ�ܷ����ڲ���Դ
		//request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
	}

}
