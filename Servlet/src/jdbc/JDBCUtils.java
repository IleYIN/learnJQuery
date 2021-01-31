package jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCUtils {
	
	/**
	 * 	运行loginJDBC.html run on server
	 */
	
	public static Properties properties = new Properties();
	static {
		try {
			//new File是直接在工程项目根下获取，如果properties文件放在webContent里就不能获取了
//			properties.load(new FileInputStream(new File("jdbc.properties")));
//			Class.forName(properties.getProperty("jdbcDriver"));

			//也不能在webContent里用new File("WebContent/xxx.properties") 因为发布的项目里并没有webContent文件夹
			//可以把properties文件放在src里，src里的东西都被编译放在WEB-INF/classes里
			
			//获取jdbc.properties需要在类路径下找
//			ClassLoader loader = JDBCUtils.class.getClassLoader();
//			InputStream stream = loader.getResourceAsStream("jdbc.properties");
//			properties.load(stream);
//			Class.forName(properties.getProperty("jdbcDriver"));
			
			//为了模块化处理，应该建一个源码文件夹，如conf，然后把配置文件放在其中
//			ClassLoader loader = JDBCUtils.class.getClassLoader();
//			InputStream stream = loader.getResourceAsStream("jdbc2.properties");
//			properties.load(stream);
//			Class.forName(properties.getProperty("jdbcDriver"));
			
			//注意classloader不能写系统的类（如String.class.getClassLoader()），否则会空指针异常
			//如果properties在包里
			ClassLoader loader = JDBCUtils.class.getClassLoader();
			InputStream stream = loader.getResourceAsStream("jdbc/jdbc3.properties");
			properties.load(stream);
			Class.forName(properties.getProperty("jdbcDriver"));
			
			//获取properties 需要在类路径下找
			//类加载器获取资源会在类路径下找（WEB-INF/classes）
			
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
