package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyEclipseServlet
 * 
 * HttpServletר��Ϊ����Http�����Ƶ�Servlet webӦ��
 * 
 */
public class MyEclipseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyEclipseServlet() {
        super();
        System.out.println("constructer...");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * doGet��������get����ʽ
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ÿ���������doGet����
		//�����������Ǹ����������֣�����дһ����Ȼ����һ�����ã���doPost����doGet
		System.out.println("doGet..");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 *  doPost����post����
	 *  
	 *  postĿǰ��ֻ��һ�֣����ύ��ʱ��ָ��method="post"
	 *   �س��������ӣ�img��src="ͼƬ·��"�ȶ���get����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//HttpServletRequest request��HttpServletResponse response�ɷ���������
		//HttpServletRequest request����ľ��Ƿ�װ�����������Ϣ�Ķ����յ���������˵�����
		//HttpServletResponse response����ľ���Ҫ�������������Ӧ���󣬷�װ��Ӧ��Ϣ��
		
		//һ�������Ӧһ����Ӧ
		//���ã�1.���Ը��������Ӧ�ַ���
//		PrintWriter writer = response.getWriter();
//		writer.write("hello httpservlet....");

		response.sendRedirect("success.html");
		String username = request.getParameter("username");
		System.out.println(username);
		
		//һ�������Ӧһ����Ӧ,�ύ��Ӧ���޷�ת��
		request.getRequestDispatcher("success.html").forward(request, response);
		
		//2.�����ض���һ��ҳ�����������Դ��������������Դ
		//�ҵĴ������...�Ѿ���֮ǰ��request��Ӧ����
		
		
		System.out.println("doPost..");
		doGet(request, response);
	}

}
