package com.example.mybeachspot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticator {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mybeachspot"; // Change this to your database URL
    private static final String DB_USER = "root"; // Change this to your database username
    private static final String DB_PASSWORD = ""; // Change this to your database password

    public static boolean authenticate(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean authenticated = false;

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Prepare a statement to retrieve the user's password hash from the database
            stmt = conn.prepareStatement("SELECT password_hash FROM users WHERE username = ?");
            stmt.setString(1, username);

            // Execute the query
            rs = stmt.executeQuery();

            // If a row was returned, check the password hash against the submitted password
            if (rs.next()) {
                String passwordHash = rs.getString("password_hash");
                authenticated = PasswordHash.validatePassword(password, passwordHash);
            }
        } catch (SQLException | ClassNotFoundException e) {
            // Handle any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close any database resources that were opened
            try { rs.close(); } catch (Exception e) { /* ignored */ }
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { conn.close(); } catch (Exception e) { /* ignored */ }
        }

        return authenticated;
    }
}

