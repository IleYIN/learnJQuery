package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// filterConfig是封装filter配置信息的对象
		String filterName = filterConfig.getFilterName();//filter别名
		// filter初始化参数
		String initParameterFilter = filterConfig.getInitParameter("username");
		// ServletContext 对应web应用
		ServletContext servletContext = filterConfig.getServletContext();
		// 获取web初始化参数
		String initParameterWeb = servletContext.getInitParameter("user");
		System.out.println("filter别名:"+filterName+",filter初始化参数:"+initParameterFilter
				+",获取servletContext:"+servletContext+",web全局初始化参数:"+initParameterWeb);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("我是Afilter的dofilter--1");
		HttpServletRequest req = (HttpServletRequest) request;
//		String requestURI = req.getRequestURI();
//		StringBuffer requestURL = req.getRequestURL();
//		System.out.println("uri-"+requestURI);
//		System.out.println("url-"+requestURL);
//		//只拦截page下的所有jsp，虽然web.xml会拦截page下所有的资源
//		if(requestURI.endsWith("jsp")) {
//			System.out.println("jsp结尾的，我就拦截");
//		} else {
//			chain.doFilter(request, response);
//		}
		//预处理
		//放行之前只要写中文就乱码，放行之后写则没问题
		//根本原因是以上操作在请求过来到完成响应整个过程中，服务器使用的都是这一个request和对应的的response
		//解决乱码问题一定要在response之前设置
		response.setContentType("text/html;charset=utf-8");
		//一个请求对应一个响应，只要请求来了，立刻会先造一个响应对象
		//以后处理整个请求都是用的这个request和这个response
		//jsp就是给这个response添加响应内容。jsp页面执行service，一开始就设置编码。
		//放行请求就是等jsp把整个response造完返回给filter
		response.getWriter().write("helloworld");
		//chain就是用来放行请求，只要不显式调用放行方法，请求就不会被执行
		chain.doFilter(request, response);
		System.out.println("我是Afilter的dofilter--2");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
