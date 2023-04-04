package com.example.mybeachspot;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {


    private static final long serialVersionUID = 1L;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    private static final String SELECT_USER_SQL = "SELECT password_hash FROM users WHERE username = ?";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String error = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            PreparedStatement ps = conn.prepareStatement(SELECT_USER_SQL);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String passwordHash = rs.getString("password_hash");
                if (PasswordHash.validatePassword(password, passwordHash)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);

                    response.sendRedirect("home.jsp");
                    return;
                } else {
                    error = "Invalid password";
                }
            } else {
                error = "Invalid username";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            error = "Database error";
        }

        response.sendRedirect("login.jsp?error=" + error);
    }
}