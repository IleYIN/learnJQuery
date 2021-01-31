package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 一个Servlet只能处理一个指定的请求
 * 
 * 应该指定servlet处理那个请求
 * 需要在web.xml里面配置servlet的详细信息
 *
 *
 * 1. 创建自己的类来实现servlet接口
 * 2. 在service方法里面写代码
 * 3. 在web.xml里配置
 */
public class MySecondServlet implements Servlet {
//导入源代码包，这样add unimplemented method参数就会显示
	
	//初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	//获取servlet配置信息
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	//服务
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 用来处理来自客户端的请求
		System.out.println("second servlet");
		//ServletResponse res给浏览器发送一个响应
		PrintWriter writer = res.getWriter();
		writer.write("HelloServlet");
	}

	//获取servlet信息
	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	//销毁
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
