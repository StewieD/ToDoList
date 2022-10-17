package database;

import java.sql.Connection;
import java.sql.DriverManager;


public class JDBCUtil {
	public static Connection getConnection() {
		Connection c =null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			String sql = "jdbc:mySQL://localhost:3306/todolist";
			String username = "haidan20";
			String password = "zxc123";
			c = DriverManager.getConnection(sql, username, password);
		} catch (Exception e) {
			System.out.println("Error JDBCUtil");
		}
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if(c!=null)
				c.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
