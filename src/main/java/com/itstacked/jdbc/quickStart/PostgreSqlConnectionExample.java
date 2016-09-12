package com.itstacked.jdbc.quickStart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSqlConnectionExample {

    private Connection connection = null;

    public void loadDriver() {
        System.out.println("Looking for PostgreSQL Driver on classpath.");

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("PostgreSQL JDBC Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("No PostgreSQL driver found on classpath.  Please add PostgreSQL Driver to classpath.");
            throw new RuntimeException(e);
        }
    }


    public void connect(final String userName, final String password) {

        try {
            System.out.println( String.format("Attempting to connect to PostgreSQL Database with user: %s and password: %s ",
                    userName, password));

            connection = DriverManager
                    .getConnection("jdbc:postgresql://127.0.0.1:5432/javaCore",
                            userName, password);

        } catch (SQLException e) {
            System.out.println("Error unable to connect. Check console stack trace.");
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
        }
        catch(Exception e) {
            System.err.println("Warning connection not closed");
        }
    }



    public Connection getConnection() {
        return connection;
    }


    public static void main(String[] args) {
        PostgreSqlConnectionExample example = new PostgreSqlConnectionExample();

        try {
            example.loadDriver();
            example.connect("root", "root");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            example.closeConnection();
        }
    }
}
