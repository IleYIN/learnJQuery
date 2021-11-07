package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JDBCUtils; 

/**
 * TrasactionFilter类用于管理事务
 */
public class TransactionFilter implements Filter {

	public TransactionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long id = Thread.currentThread().getId();
		System.out.println("filter放行前的线程号"+id);
		//拿到当前线程的连接
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
		}
		try {
			// 放行操作
			chain.doFilter(request, response);
			System.out.println("filter已放行...");
			//没有异常，并提交事务
			connection.commit();
		} catch (Exception e) {
			System.out.println("filter收到异常了..."+e.getMessage());
			// 回滚 事务
			try {
				JDBCUtils.getConnection().rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			HttpServletResponse reps = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			reps.sendRedirect(req.getContextPath()+"/pages/exception.jsp");
		}
		//关闭连接 改在TransactionFilter里面关闭连接 用filter控制事务
		JDBCUtils.releaseConnection(connection);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
