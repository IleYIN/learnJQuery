package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 	��ȡ���ͷ����ݿ�����
 * @author yinyiliang
 *
 */
public class JDBCUtils {
	
	//��ȡc3p0���ӳ�
	//static��֤ʹ�õ���ͬһ�����ݿ����ӳ� ���⿪�����
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	
	private static Map<Long, Connection> conns = new HashMap<>();
	/**
	 * ʹ��ThreadLocal����Connection����
	 */
//	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

	
	/**
	 *	 ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		long id = Thread.currentThread().getId();
		System.out.println("JDBCUtils�е��̺߳ţ�"+id);
		Connection connection = conns.get(Thread.currentThread().getId());
		// �ȴ�ThreadLocal�л�ȡ
//		Connection connection = connectionThreadLocal.get();
		// ��ȡ��ǰ�̵߳�����
		try {
			if (connection == null) {
				// ��c3p0�л�ȡ���ݿ�����
				connection = ds.getConnection();
				// ��������Ϊ�ֶ��ύ
				connection.setAutoCommit(false);
				//�����ӱ�����Map�У�����һ������ʱ��map��û�У������½���һ��
				//�������棬�Ժ��κ�ֻҪ�õ�ǰ�̺߳Ż�ȡ������ȡ�����ǵ�ǰ�̶߳�Ӧ������
				conns.put(id, connection);
				//connectionThreadLocal.set(connection);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * 	�ͷ����ݿ�����
	 * @param connection
	 */
	public static void releaseConnection(Connection connection) {
		try {
			if(connection != null) {
				connection.close();
				conns.remove(Thread.currentThread().getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
