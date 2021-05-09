package utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 	获取和释放数据库连接
 * @author yinyiliang
 *
 */
public class JDBCUtils {
	
	//获取c3p0连接池
	//static保证使用的是同一个数据库连接池 避免开多个池
	private static DataSource ds = new ComboPooledDataSource("webDataSource");
	
	/**
	 *	 获取数据库连接
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
	 * 	释放数据库连接
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
