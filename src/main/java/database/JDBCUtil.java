package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			String url = "jdbc:mysql://localhost:3306/qltv";
			String username = "root";
			String password = "";
			
			c = DriverManager.getConnection(url,username,password); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
