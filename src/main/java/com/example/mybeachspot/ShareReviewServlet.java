package com.example.mybeachspot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/share-review")
public class ShareReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private List<BeachReview> beachReviews = new ArrayList<>();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            request.setAttribute("username", username);
            request.getRequestDispatcher("/share-review.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String beachName = request.getParameter("beachName");
        String review = request.getParameter("review");
        int rating = Integer.parseInt(request.getParameter("rating"));
        BeachReview beachReview = new BeachReview(beachName, review, rating);
        beachReviews.add(beachReview);
        response.sendRedirect(request.getContextPath() + "/home");
    }


}
