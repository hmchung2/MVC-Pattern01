package kr.ac.kopo.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//String url = "jdbc:oracle:thin:@192.168.217.57:1522:xe";
			//String url = "jdbc:oracle:thin:@192.168.119.119:1521:dink";
			String url = "jdbc:oracle:thin:@192.168.127.111:1521:cdb1";
			//String user = "hr";
			//String password = "hr";
			//String user  = "scott";
			String user ="hmchung2";			
			String password = "1234";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
