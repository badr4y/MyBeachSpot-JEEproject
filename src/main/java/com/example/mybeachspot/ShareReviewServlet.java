package com.example.mybeachspot;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/share-review")
public class ShareReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    //private List<BeachReview> beachReviews = new ArrayList<>();

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
        /*BeachReview beachReview = new BeachReview(beachName, review, rating);
        beachReviews.add(beachReview);*/

        // Store the feedback in the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("INSERT INTO feedback (Beach_Name, Rating, Review) VALUES (?, ?, ?)");
            ps.setString(1, beachName);
            ps.setInt(2, rating);
            ps.setString(3, review);
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String popupHtml = "<html><head><title>Success</title></head><body><script>alert('Your review is added!');</script></body></html>";
        out.println(popupHtml);
        response.sendRedirect(request.getContextPath() + "/share-review");
    }


}
