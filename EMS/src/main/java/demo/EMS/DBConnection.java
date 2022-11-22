package demo.EMS;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;

	public static Connection createDBConnection() throws Exception {

		try {
			// load driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// get Connection
			String url = "jdbc:mysql://localhost:3306/employeedb?useSSL=false";
			String username = "root";
			String password = "1241";
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}
}
