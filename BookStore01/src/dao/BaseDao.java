package dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import utils.JDBCUtils;

public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	
	//需要获取实际的type  
	//<T> the type of the class modeled by this Class object. For example, the type of String.class is Class<String>
	private Class<T> type;
	
	public BaseDao() {
		// this代表该子类
		// 获取父类的类型，父类是带参数的（参数T)
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//System.out.println(superclass.getClass());
		//superClass.getClass()返回class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
		
		//获取参数的类型
		type = (Class<T>) superclass.getActualTypeArguments()[0];
		
	}
	
	/**
	 * 	获取一个对象	
	 * @param sql
	 * @param params 可变参数
	 * @return
	 */
	public T getBean(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		T query = null;
		try {
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
			//BeanHandler利用反射机制创造type的对象， 调用空参构造器，所以必须有User的空参构造器
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	
	/**
	 * 	获取对象的集合
	 * @return
	 */
	public List<T> getBeanList(String sql, Object...params){
		Connection connection = JDBCUtils.getConnection();
		List<T> query = null;
		try {
			query = runner.query(connection, sql, new BeanListHandler<>(type), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	
	/**
	 * 	执行增删改
	 * @param sql
	 * @param params 可变参数
	 * @return
	 */
	public int update(String sql, Object ...params) {
		int count = 0;
		Connection connection = JDBCUtils.getConnection();
		try {
			count = runner.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		
		return count;
	}
}
