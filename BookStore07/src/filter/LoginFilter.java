package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import bean.User;
import utils.WebUtils;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("filter已经启动");
		//验证用户是否登录，登录则放行，否则转到登录页面
		HttpServletRequest req = (HttpServletRequest) request;
		User user = WebUtils.getLoginUser(req);
		if(user==null) {
			//直接返回登录页面提示用户登录
			request.setAttribute("msg", "此操作需要登录，请先登录");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
