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
		
		//ServletContext对象
		//一个web应用对应一个ServletContext,代表整个web项目
		//功能：
		//1.可以获取web项目的配置信息，获取web项目的初始化参数
		String user = servletContext.getInitParameter("user");
		String username = servletContext.getInitParameter("username");
		//System.out.println(user+"-->"+username);
		//2.获取web的项目路径 虚拟路径
		String path = servletContext.getContextPath();
		System.out.println(path);
		//3.获取资源的真实路径
		//虚拟路径：网络访问使用的路径，对应一个实际的资源
		//静态资源（文件的形式），动态资源（只是启动一段程序代码）
		//url(虚拟路径)->DNS->server->某个项目->资源(真实路径)
		//真实路径：在文件磁盘中的存储路径 
		String realPath = servletContext.getRealPath("/index.html");
		System.out.println(realPath);
		//getRealPath("资源在web项目下的虚拟路径")
		//既可以获取存在的资源的真实路径通过输出流往外写，也可以获取未存在的资源通过输入流往里写
		//4.可以作为最大的域对象共享数据   域对象：共享数据
		//四大域对象（pageContext,request,session,application）之一：application域对象
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
