package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncodingServlet
 */
public class EncodingServlet extends HttpServlet {
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
		//�ڵ�һ�β���response֮ǰ�����ú��������ͺ��ַ�����
		
		//����1
		//����������Ҵ�������ݵ���������
//		response.setContentType("text/html");
		//�������������
//		response.setCharacterEncoding("GBK");
		//ע�����ñ���Ҫ�ڻ�ȡ��֮ǰ����
		
		//����2
		//ֱ��������Ӧͷ
//		response.addHeader("Content-Type", "text/html;charset=GBK");		

		//����3-����Content-Type�ֶ�
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		writer.write("����ɹ���");
		
		//�ַ�����������µط�
		/**
		 * 1.��Ӧ�������������������
		 * 		ԭ������������֪�����ݵ����ͼ������ʽ
		 * 		���������·�����������ͼ������ʽ������Ӧͷ��Content-Type��
		 * 		������3�� response.setContentType("text/html;charset=UTF-8");	 */
		
	}
}
