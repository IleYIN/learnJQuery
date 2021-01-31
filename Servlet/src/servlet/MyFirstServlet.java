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
 * 
 * 
 * Servlet的生命周期:从创建到销毁的过程
 * 
 * Servlet是跑在Tomcat服务器上的
 * Tomcat服务器--->Servlet容器
 * 
 * 当我们第一次访问HelloServlet时：
 * 1.服务器创建一个Servlet对象 
 * 2.调用init方法初始化servlet
 * 3.调用service方法处理请求
 * 以后请求：
 * 4.只调用service方法处理请求，
 * 	整个运行期间只创建了一个servlet对象
 * （单实例多线程）servlet里一般不写共享变量，避免线程安全问题
 * 当项目从服务器上卸载：
 * 5.服务器会调用destroy方法 销毁方法，清理善后
 * 
 * 
 * 
 * 
 * web.xml
 *  <servlet>在servlet标签配置servlet的类信息 + 告诉服务器我有这个servlet
  	<servlet-name>配置servlet的名字 相当于MyFirstServlet的别名
  	 <servlet-class>配置servlet类的全名 给服务器看，服务器是通过全类名找到MyFirstServlet
  <servlet-mapping>servlet映射信息 也就是servlet用来处理哪一个请求 
  <servlet-name> 刚才配置的MyFirstServlet类的别名
 	<url-pattern>告诉服务器这个servlet用来处理哪个请求  http://localhost:8080/Servlet/helloWorld 
 	 访问当前项目下的动态资源/helloWorld（没有找到这个静态资源时）,调用它所绑定的servlet代码
  	执行index.html run on server
  	用户在浏览器地址栏输入http://localhost:8080/Servlet/helloWorld
  	服务器看是否有静态资源对应，没有相应的静态资源，则服务器去找动态资源url-pattern
  	进而找到对应绑定的servlet类并执行代码service方法
  	
  	使用eclipse直接创建servlet，会自动补好相关标签在web.xml里
 * 
 * 
 */
public class MyFirstServlet implements Servlet {
//导入源代码包，这样add unimplemented method参数就会显示
	
	public MyFirstServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("MyFirstServlet()");
	}
	//初始化
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init()");
	}

	//获取servlet配置信息
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		System.out.println("getServletConfig()");
		return null;
	}

	//服务
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service()");
		// 用来处理来自客户端的请求
		System.out.println("first servlet");
		//ServletResponse res给浏览器发送一个响应
		PrintWriter writer = res.getWriter();
		writer.write("HelloWorld");
	}

	//获取servlet信息
	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo()");
		// TODO Auto-generated method stub
		return null;
	}

	//销毁
	@Override
	public void destroy() {
		System.out.println("destroy()");
		// TODO Auto-generated method stub
		
	}

}
