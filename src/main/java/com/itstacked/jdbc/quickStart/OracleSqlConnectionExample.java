package com.itstacked.jdbc.quickStart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleSqlConnectionExample {

	private Connection connection = null;

	public void loadDriver() {
		System.out.println("Looking for Oracle Driver on classpath.");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC Driver Loaded");
		} catch (ClassNotFoundException e) {
			System.out
					.println("No Oracle driver found on classpath.  Please add Oracle Driver to classpath.");
			throw new RuntimeException(e);
		}
	}

	public void connect(final String userName, final String password) {

		try {
			System.out
					.println(String
							.format("Attempting to connect to Oracle Database with user: %s and password: %s ",
									userName, password));

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:javaCore", userName,
					password);

		} catch (SQLException e) {
			System.out
					.println("Error unable to connect. Check console stack trace.");
			throw new RuntimeException(e);
		}
	}

	public void closeConnection() {
		if (connection != null) {
			System.out.println("Connection to database successful.");

		} else {
			System.out.println("Failed to connect to database");
		}

		try {
			connection.close();
		} catch (Exception e) {
			System.err.println("Warning connection not closed");
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static void main(String[] args) {
		OracleSqlConnectionExample example = new OracleSqlConnectionExample();

		try {
			example.loadDriver();
			example.connect("root", "password");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			example.closeConnection();
		}
	}
}
