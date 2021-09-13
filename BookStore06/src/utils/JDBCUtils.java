package utils;

import java.sql.Connection;
import java.sql.SQLException;

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
	
	/**
	 *	 ��ȡ���ݿ�����
	 * @return
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = ds.getConnection();
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
