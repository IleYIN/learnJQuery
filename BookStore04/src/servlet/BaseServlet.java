package servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * if(��¼����)
		 * {
		 * 	�����û���¼
		 * } else if(ע������)
		 * {
		 * 	�����û�ע��
		 * } else if(�޸�����)
		 * {
		 * 	�����޸�����
		 * }
		 *	����Ϊpost�������һ��method�ֶΣ��ύ��ʱ�򣬴���methodֵ
		 * 	ע�⣺get���󣬱������ݻᱻ���ϣ���֮ǰ�����ַ�е����ݻᱻ�����ݸ���
		 * 		��ʱ��Ҫ���һ�������������ݻᱻ�ύ��
		 * 
		 * 	Ϊ�˱����ظ��жϣ������÷��������
		 * 	���е�servlet����ͨ��������������Ӧ�ķ������������ǿ��Գ�ȡ��һ��BaseServlet
		 */
		//������룬Ҫ�ڻ�δ��ȡ����֮ǰ���ñ���
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		//System.out.println(method);
//		if("regist".equals(method)) {
//			//ע������
//			regist(request, response);
//		
//		} else if("login".equals(method)) {
//			//��¼����
//			login(request, response);
//		}
		try {
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			method2.setAccessible(true);
			//invoke(���󣬲���);
			method2.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
