package servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.code.kaptcha.Constants;

import bean.User;
import service.UserService;
import service.impl.UserServiceImpl;
import utils.WebUtils;

/**
 * Servlet implementation class UserServlet
 * 
 * 	抽取出BaseServlet后，UserServlet只需要编写相应的处理逻辑即可
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService us = new UserServiceImpl();

	//方法名(request,response)
	
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取用户输入的验证码，获取session中的验证码
		String code = request.getParameter("code");//页面中的验证码
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println("页面的验证码："+code);
		System.out.println("session中的验证码："+sessionCode);
		
		//如果验证码不一致，则回到注册页面并提示验证码错误
		if(!sessionCode.equals(code)) {
			request.setAttribute("msg", "验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			return;
		}
		
		User user = WebUtils.param2bean(request, new User());
		
		boolean b = us.regist(user);
		if(b) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//页面提交时会带一个令牌
			//在servlet中应该有一个一模一样的令牌，这样每次提交来的数据会带上令牌，
			//服务器可以验证和本地的令牌是否一致
			//HttpSession session = request.getSession();
			//服务器从session中取出的令牌
			String token = (String)session.getAttribute("token");
			System.out.println("sessionToken:"+token);
			//把这里的session中的令牌token改变或移除，
			//这样回退操作从缓存中得到的token和session中的token不一样
			session.removeAttribute("token");
			
			//页面中取出令牌进行对照
			String pageToken = request.getParameter("token");
			System.out.println("pageToken:"+pageToken);
			if(pageToken == null) {
				pageToken = "";
			}
			
			if(pageToken.equals(token)) {
				//注册成功 返回成功页面 重定向
				response.sendRedirect(request.getContextPath() + "/pages/user/regist-success.jsp");
				//request.getRequestDispatcher("/pages/user/regist-success.jsp").forward(request, response);
			}  else {
				response.sendRedirect(request.getContextPath() + "/pages/user/regist-error.jsp");
			}
		} else {
			//注册失败 返回注册页面，重新注册 转发
			request.setAttribute("msg", "用户已存在");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user2 = WebUtils.param2bean2(request, new User());
		//用户登录，用户的详情
		User user = us.login(user2);
		//System.out.println(user);
		
		//将用户保存到session中
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		
		if(user == null || user.getUsername() == null || user.getUsername().isEmpty()) {
			//登录失败 返回登录页面即可 转发
			request.setAttribute("msg","用户名密码错误");
			//也可以设置上要回显的项目
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			//登录成功 放回成功页面 重定向
			response.sendRedirect(request.getContextPath()+"/pages/user/login-success.jsp");
		}
	}

	/**
	 * 	用户登出操作
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//销毁session即可
		session.invalidate();
		//点完登出返回商城首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	/**
	 * 	检查用于是否可用
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 页面应该把用户名传过来 key应该是username
		// 页面传来的user对象
		User user = WebUtils.param2bean(request, new User());
		// 检查用户是否可用
		boolean b = us.checkUser(user);
		if(b) {
			//可以注册，写数据就是给客户端响应
			response.getWriter().write("用户名可用");
		} else {
			//不可以注册
			response.getWriter().write("用户已存在");
		}
	}
}
