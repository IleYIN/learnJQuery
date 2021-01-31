package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtils {
	
	/**
	 * 	����loginJDBC.html run on server
	 */
	
	public static Properties properties = new Properties();
	static {
		try {
			//new File��ֱ���ڹ�����Ŀ���»�ȡ�����properties�ļ�����webContent��Ͳ��ܻ�ȡ��
//			properties.load(new FileInputStream(new File("jdbc.properties")));
//			Class.forName(properties.getProperty("jdbcDriver"));

			//Ҳ������webContent����new File("WebContent/xxx.properties") ��Ϊ��������Ŀ�ﲢû��webContent�ļ���
			//���԰�properties�ļ�����src�src��Ķ��������������WEB-INF/classes��
			
			//��ȡjdbc.properties��Ҫ����·������
//			ClassLoader loader = JDBCUtils.class.getClassLoader();
//			InputStream stream = loader.getResourceAsStream("jdbc.properties");
//			properties.load(stream);
//			Class.forName(properties.getProperty("jdbcDriver"));
			
			//Ϊ��ģ�黯����Ӧ�ý�һ��Դ���ļ��У���conf��Ȼ��������ļ���������
//			ClassLoader loader = JDBCUtils.class.getClassLoader();
//			InputStream stream = loader.getResourceAsStream("jdbc2.properties");
//			properties.load(stream);
//			Class.forName(properties.getProperty("jdbcDriver"));
			
			//ע��classloader����дϵͳ���ࣨ��String.class.getClassLoader()����������ָ���쳣
			//���properties�ڰ���
			ClassLoader loader = JDBCUtils.class.getClassLoader();
			InputStream stream = loader.getResourceAsStream("jdbc/jdbc3.properties");
			properties.load(stream);
			Class.forName(properties.getProperty("jdbcDriver"));
			
			//��ȡproperties ��Ҫ����·������
			//���������ȡ��Դ������·�����ң�WEB-INF/classes��
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws Exception {
		Connection connection = DriverManager.getConnection(properties.getProperty("url"), properties);
		return connection;
	}
}
