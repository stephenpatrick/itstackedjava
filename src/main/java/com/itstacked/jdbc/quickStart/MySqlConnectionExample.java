package com.itstacked.jdbc.quickStart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionExample {

	private Connection connection = null;

	public void loadDriver() {
		System.out.println("Looking for MySQL Driver on classpath.");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC Driver Loaded");
		} catch (ClassNotFoundException e) {
			System.out
					.println("No MySQL driver found on classpath.  Please add MySql Driver to classpath.");
			throw new RuntimeException(e);
		}
	}

	public void connect(final String userName, final String password) {

		try {
			System.out
					.println(String
							.format("Attempting to connect to MySql Database with user: %s and password: %s ",
									userName, password));

			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/javaCore", userName, password);

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
		MySqlConnectionExample example = new MySqlConnectionExample();

		try {
			example.loadDriver();
			example.connect("root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			example.closeConnection();
		}
	}
}
