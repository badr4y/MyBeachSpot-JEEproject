package com.example.mybeachspot;

import java.io.IOException;
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
        // Retrieve a list of ratings from the database
        List<Rating> ratings = new ArrayList<>();
        // Add some dummy data for testing
        ratings.add(new Rating("Beach A", 4));
        ratings.add(new Rating("Beach B", 3));
        ratings.add(new Rating("Beach C", 5));
        ratings.add(new Rating("Beach D", 2));
        ratings.add(new Rating("Beach E", 4));

        // Pass the ratings to the JSP page
        request.setAttribute("ratings", ratings);
        request.getRequestDispatcher("/WEB-INF/views/ratings.jsp").forward(request, response);
    }
}
