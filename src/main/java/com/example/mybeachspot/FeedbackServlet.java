package com.example.mybeachspot;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/submitFeedback" )
public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FeedbackServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String feedback = request.getParameter("feedback");

        // Store the feedback in the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("INSERT INTO feedback (name, email, rating, feedback) VALUES (?, ?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setInt(3, rating);
            ps.setString(4, feedback);
            ps.executeUpdate();

            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Retrieve the feedback from the database
        List<Feedback> feedbackList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM feedback");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String feedbackName = rs.getString("name");
                String feedbackEmail = rs.getString("email");
                int feedbackRating = rs.getInt("rating");
                String feedbackComment = rs.getString("feedback");

                Feedback feedbackObj = new Feedback(feedbackName, feedbackEmail, feedbackRating, feedbackComment);
                feedbackList.add(feedbackObj);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set the feedback list as a request attribute and forward to the feedbackview
        request.setAttribute("feedbackList", feedbackList);
        request.getRequestDispatcher("feedbackview.jsp").forward(request, response);
    }
}
