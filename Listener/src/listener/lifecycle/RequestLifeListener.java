package listener.lifecycle;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 	1、先实现接口
 * 	2、在web.xml中配置
 *
 */
public class RequestLifeListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("request对象销毁...");		
		//sre作用
		//1、获取servletContext
		//2、获取servletrequest，当前的请求
		ServletRequest request = sre.getServletRequest();
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request对象初始化...");		
	}

}
