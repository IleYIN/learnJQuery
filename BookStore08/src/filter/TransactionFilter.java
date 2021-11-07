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
 * TrasactionFilter�����ڹ�������
 */
public class TransactionFilter implements Filter {

	public TransactionFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long id = Thread.currentThread().getId();
		System.out.println("filter����ǰ���̺߳�"+id);
		//�õ���ǰ�̵߳�����
		Connection connection = JDBCUtils.getConnection();
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e1) {
		}
		try {
			// ���в���
			chain.doFilter(request, response);
			System.out.println("filter�ѷ���...");
			//û���쳣�����ύ����
			connection.commit();
		} catch (Exception e) {
			System.out.println("filter�յ��쳣��..."+e.getMessage());
			// �ع� ����
			try {
				JDBCUtils.getConnection().rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			HttpServletResponse reps = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			reps.sendRedirect(req.getContextPath()+"/pages/exception.jsp");
		}
		//�ر����� ����TransactionFilter����ر����� ��filter��������
		JDBCUtils.releaseConnection(connection);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
