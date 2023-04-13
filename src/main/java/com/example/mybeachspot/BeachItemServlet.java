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
import jakarta.servlet.ServletException;
import java.io.IOException;
@WebServlet("/beach")
public class BeachItemServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to handle GET requests

        String id = request.getParameter("id");
        List<BeachReview> beachReviews = new ArrayList<>();


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("SELECT * FROM beaches WHERE id=" + id);
            ResultSet rs = ps.executeQuery();

            Beach beach = null;
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String Beachname = rs.getString("namemobileweb");
                String beachdescription = rs.getString("descriptionmobileweb");
                String parking = rs.getString("parking");
                String disabled_access = rs.getString("dsabldacss");
                String restrooms = rs.getString("restrooms");
                String dog_friendly = rs.getString("dog_friendly");
                String sandy_beach = rs.getString("sndy_beach");
                String fishing = rs.getString("fishing");
                String boating = rs.getString("boating");
                Double latitude = rs.getDouble("latitude");
                Double longitude = rs.getDouble("longitude");
                String location = rs.getString("locationmobileweb");
                String photo_1 = rs.getString("photo_1");
                String photo_2 = rs.getString("photo_2");
                String photo_3 = rs.getString("photo_3");
                String photo_4 = rs.getString("photo_4");
                PreparedStatement ps1 = con.prepareStatement("SELECT * FROM feedback where `beach_id`="+id);
                ResultSet rs1 = ps1.executeQuery();

                while (rs1.next()) {
                    int beach_id1 = rs1.getInt("beach_id");
                    int rating1 = rs1.getInt("Rating");
                    String review1 = rs1.getString("Review");
                    BeachReview beachreview = new BeachReview(beach_id1, review1, rating1);
                    beachReviews.add(beachreview);

                }

                BeachInfo beachinfo = new BeachInfo(Beachname, beachdescription, parking, disabled_access, restrooms, dog_friendly, sandy_beach, fishing, boating, latitude, longitude, location, photo_1, photo_2, photo_3, photo_4);
                Api_response weather = new Api_response(latitude, longitude);
                weather.setWeather_info(latitude, longitude);

                beach = new Beach(id1, beachinfo, weather, beachReviews);
                System.out.println(beach);

            }


            // Pass the beach reviews to the JSP page
            request.setAttribute("beach", beach);
            request.getRequestDispatcher("/beach.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Code to handle POST requests
        String beach_id = request.getParameter("id");
        String review = request.getParameter("review");
        int rating = Integer.parseInt(request.getParameter("rating"));
        /*BeachReview beachReview = new BeachReview(beachName, review, rating);
        beachReviews.add(beachReview);*/

        // Store the feedback in the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybeachspot", "root", "");

            PreparedStatement ps = con.prepareStatement("INSERT INTO feedback (`Beach_id`, Rating, Review) VALUES (?, ?, ?)");
            ps.setString(1, beach_id);
            ps.setInt(2, rating);
            ps.setString(3, review);
            ps.executeUpdate();

            ps.close();
            con.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = request.getRequestURL().toString();

        response.sendRedirect(url+"?id="+beach_id);

    }
}
