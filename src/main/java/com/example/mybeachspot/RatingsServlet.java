package com.example.mybeachspot;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ratings")
public class RatingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BeachReview> beachReviews = new ArrayList<>();
        /* Add some dummy data for testing
        ratings.add(new Rating("Beach A", 4));
        ratings.add(new Rating("Beach B", 3));
        ratings.add(new Rating("Beach C", 5));
        ratings.add(new Rating("Beach D", 2));
        ratings.add(new Rating("Beach E", 4));*/

        // Retrieve a list of ratings from the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM feedback");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int beach_id = rs.getInt("beach_id");
                int rating = rs.getInt("Rating");
                String Review = rs.getString("Review");

                BeachReview BeachReview = new BeachReview(beach_id, Review, rating);
                beachReviews.add(BeachReview);
            }

            // Pass the beach reviews to the JSP page
            request.setAttribute("beachReviews", beachReviews);
            request.getRequestDispatcher("/ratings.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}