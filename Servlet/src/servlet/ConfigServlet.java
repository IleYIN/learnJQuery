package servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConfigServlet implements Servlet {

	private ServletConfig config = null;
	/**
	 * 初始化方法在创建时被调用一次
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//ServletConfig是封装了当前Servlet配置信息的对象，
		//一个Servlet对象对应一个ServletConfig
		this.config = config;
		//功能：1.获取servlet的别名
		String servletName = config.getServletName();
		System.out.println(servletName);
		//2.获取servlet初始化参数
		String username = config.getInitParameter("username");
		System.out.println("初始化参数:username->"+username);
		//3.获取ServletContext对象
		//ServletContext代表当前servlet的上下文，代表我当前的web项目信息
		//一个web项目对应一个ServletContext
		//ServletContext-->餐馆经理   Servlet-->餐馆服务员
		ServletContext servletContext = config.getServletContext();
		System.out.println(servletContext);
		
	}
	
	/**
	 * 	获取servlet的配置信息
	 */
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 返回servlet的描述信息
	 */
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 销毁servlet对象
	 * 服务器停止或者卸载项目时销毁
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
