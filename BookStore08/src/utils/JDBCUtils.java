package utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

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
	
	private static Map<Long, Connection> conns = new HashMap<>();
	/**
	 * 使用ThreadLocal保存Connection对象
	 */
//	private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();

	
	/**
	 *	 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		long id = Thread.currentThread().getId();
		System.out.println("JDBCUtils中的线程号："+id);
		Connection connection = conns.get(Thread.currentThread().getId());
		// 先从ThreadLocal中获取
//		Connection connection = connectionThreadLocal.get();
		// 获取当前线程的连接
		try {
			if (connection == null) {
				// 从c3p0中获取数据库连接
				connection = ds.getConnection();
				// 设置事务为手动提交
				connection.setAutoCommit(false);
				//把连接保存在Map中，当第一次连接时，map中没有，我们新建了一个
				//把它保存，以后任何只要拿当前线程号获取，都获取到的是当前线程对应的连接
				conns.put(id, connection);
				//connectionThreadLocal.set(connection);
			}
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
				conns.remove(Thread.currentThread().getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
