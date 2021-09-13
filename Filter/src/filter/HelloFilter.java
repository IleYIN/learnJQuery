package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 *	创建Filter的实现类
 *	过滤所以要访问hello页面的请求
 *	服务器的三大组件，运行在服务器上，服务器调用，配置
 *	1、 写一个实现类
 *	2、 在服务器配置filter要过滤哪些请求 web.xml
 * 
 * 	服务器管理的filter，生命周期
 * 	从创建到销毁的过程
 *	1、创建-初始化	
 *	服务器已启动，（项目加载进服务器），创建filter对象，并执行初始化。单例多线程。
 *	2、每次拦截都执行
 *	doFilter方法
 *	3、销毁
 *	项目从服务器中卸载（destroy）
 */
public class HelloFilter implements Filter {

	public HelloFilter() {
		System.out.println("构造器方法");
	}
	/**
	 * 	初始化方法
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("初始化方法");
	}

	/**
	 * 	执行过滤
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("我是拦截器-1");
		String condition = request.getParameter("condition");
		if(condition != null) {
			//将请求放行
			chain.doFilter(request, response);
			System.out.println("请求放行之后-2");
			// 服务器输出的内容响应追加一句话
			response.getWriter().write("helloFilter...");
		} else {
			// 不满足条件
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("条件不满足");
		}
	}

	/**
	 * 	销毁方法
	 */
	@Override
	public void destroy() {
		System.out.println("销毁方法");
	}

}
