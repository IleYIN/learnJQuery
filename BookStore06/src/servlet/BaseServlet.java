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
		 * if(登录请求)
		 * {
		 * 	调用用户登录
		 * } else if(注册请求)
		 * {
		 * 	调用用户注册
		 * } else if(修改密码)
		 * {
		 * 	调用修改密码
		 * }
		 *	可以为post请求添加一个method字段，提交的时候，带上method值
		 * 	注意：get请求，表单的数据会被带上，而之前请求地址中的数据会被表单数据覆盖
		 * 		这时需要添加一个表单项，表单项的数据会被提交上
		 * 
		 * 	为了避免重复判断，可以用反射来解决
		 * 	所有的servlet都是通过反射来调用相应的方法，所以我们可以抽取出一个BaseServlet
		 */
		//解决乱码，要在还未获取数据之前设置编码
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		//System.out.println(method);
//		if("regist".equals(method)) {
//			//注册请求
//			regist(request, response);
//		
//		} else if("login".equals(method)) {
//			//登录请求
//			login(request, response);
//		}
		try {
			Method method2 = this.getClass().getDeclaredMethod(method, HttpServletRequest.class, HttpServletResponse.class);
			method2.setAccessible(true);
			//invoke(对象，参数);
			method2.invoke(this, request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
