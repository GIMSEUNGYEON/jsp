package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Factory Object[Method] Pattern
 *  : 객체의 생성을 전담하는 객체를 별도로 운영하는 구조.
 */
public class ConnectionFactory {
	
	private static String url;
	private static String user;
	private static String password;
	
	static {
		ResourceBundle dbInfo = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo");
		url = dbInfo.getString("url");
		user = dbInfo.getString("user");
		password = dbInfo.getString("password");
		try {
			Class.forName(dbInfo.getString("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;
	}
	
}
