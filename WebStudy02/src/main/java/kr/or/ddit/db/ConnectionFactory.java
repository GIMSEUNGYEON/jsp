package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Factory Object[Method] Pattern : 객체의 생성을 전담하는 객체를 별도로 운영하는 구조.
 */
public class ConnectionFactory {

	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;

	static {
		ResourceBundle dbInfo = ResourceBundle.getBundle("kr.or.ddit.db.dbInfo");
		url = dbInfo.getString("url");
		user = dbInfo.getString("user");
		password = dbInfo.getString("password");

		BasicDataSource bds = new BasicDataSource();
		dataSource = bds;
		bds.setDriverClassName(dbInfo.getString("driverClassName"));
		bds.setUrl(url);
		bds.setUsername(user);
		bds.setPassword(password);
		bds.setInitialSize(Integer.parseInt(dbInfo.getString("initialSize"))); // 5개 빌려줄 수 잇음
		bds.setMaxWaitMillis(Long.parseLong(dbInfo.getString("maxWait"))); // 6번째 손님이 왔을 때 반납된게 없다면 2초 대기 시킴
		bds.setMaxTotal(Integer.parseInt(dbInfo.getString("maxTotal"))); // 2초 대기했는데도 반납된게 없다면 maxTotal을 확인하여 여유가 있다면 추가
																			// 생성함
		// 7 - 5개까지 새로 생성할 수 있고, 그 이상 손님이 온다면 예외 발생
		bds.setMaxIdle(Integer.parseInt(dbInfo.getString("maxIdle"))); // 풀에 남아있을 수 있는 개수 initialsize보다 적다면 그 수가 최대개수가
																		// 되므로 같거나 크게 설정함

//		try {
//			Class.forName(dbInfo.getString("driverClassName"));
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
	}

	public static Connection getConnection() throws SQLException {

//		Connection conn = DriverManager.getConnection(url, user, password);
		Connection conn = dataSource.getConnection();
		return conn;
	}

}
