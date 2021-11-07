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
		System.out.println("filter�Ѿ�����");
		//��֤�û��Ƿ��¼����¼����У�����ת����¼ҳ��
		HttpServletRequest req = (HttpServletRequest) request;
		User user = WebUtils.getLoginUser(req);
		if(user==null) {
			//ֱ�ӷ��ص�¼ҳ����ʾ�û���¼
			request.setAttribute("msg", "�˲�����Ҫ��¼�����ȵ�¼");
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
