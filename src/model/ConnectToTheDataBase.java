package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToTheDataBase {
private static Connection connection;
	
	public static boolean initConnection() {
		Connection initialConnection = null;
		String url = "jdbc:mariadb://localhost:3306/bankdatabase";
		String user = "root";
		String password = "projetoBanco";
		
		try {
			initialConnection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			return false;
		}
		connection = initialConnection;
		return true;
	}

	public static Connection getConnection() {
		return connection;
	}
}
