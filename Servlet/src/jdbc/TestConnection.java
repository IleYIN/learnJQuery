package jdbc;

import java.sql.Connection;

import org.junit.Test;

public class TestConnection {
	@Test
	public void test() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		System.out.println(connection);
	}
}
