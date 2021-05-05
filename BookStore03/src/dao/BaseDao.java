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
	
	//��Ҫ��ȡʵ�ʵ�type  
	//<T> the type of the class modeled by this Class object. For example, the type of String.class is Class<String>
	private Class<T> type;
	
	public BaseDao() {
		// this���������
		// ��ȡ��������ͣ������Ǵ������ģ�����T)
		ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//System.out.println(superclass.getClass());
		//superClass.getClass()����class sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl
		
		//��ȡ����������
		type = (Class<T>) superclass.getActualTypeArguments()[0];
		
	}
	
	/**
	 * 	��ȡһ������	
	 * @param sql
	 * @param params �ɱ����
	 * @return
	 */
	public T getBean(String sql, Object...params) {
		Connection connection = JDBCUtils.getConnection();
		T query = null;
		try {
			query = runner.query(connection, sql, new BeanHandler<>(type), params);
			//BeanHandler���÷�����ƴ���type�Ķ��� ���ÿղι����������Ա�����User�Ŀղι�����
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.releaseConnection(connection);
		}
		return query;
	}
	
	/**
	 * 	��ȡ����ļ���
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
	 * 	ִ����ɾ��
	 * @param sql
	 * @param params �ɱ����
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
