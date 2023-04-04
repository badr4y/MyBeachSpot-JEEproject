package com.example.mybeachspot;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/signup")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    private static final String SELECT_USER_SQL = "SELECT username FROM users WHERE username = ?";
    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password_hash) VALUES (?, ?)";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        String error = null;

        if (!password.equals(confirmPassword)) {
            error = "Passwords do not match";
        } else {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                PreparedStatement ps = conn.prepareStatement(SELECT_USER_SQL);
                ps.setString(1, username);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    error = "Username already taken";
                } else {
                    String passwordHash = PasswordHash.createHash(password);

                    ps = conn.prepareStatement(INSERT_USER_SQL);
                    ps.setString(1, username);
                    ps.setString(2, passwordHash);

                    ps.executeUpdate();

                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);

                    response.sendRedirect("home.jsp");
                    return;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                error = "An error occurred while accessing the database";
            } catch (Exception e) {
                throw new ServletException("Error creating password hash", e);
            }
        }

        if (error != null) {
            response.sendRedirect("signup.jsp?error=" + error);
        }
    }
}

