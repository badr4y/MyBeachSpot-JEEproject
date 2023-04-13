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

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Beach> beaches = new ArrayList<>();
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

            PreparedStatement ps = con.prepareStatement("SELECT * FROM beache LIMIT 30");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
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



                BeachInfo beachinfo = new BeachInfo(Beachname, beachdescription,  parking, disabled_access, restrooms, dog_friendly, sandy_beach, fishing, boating, latitude, longitude, location, photo_1, photo_2, photo_3, photo_4);
                Api_response weather = new Api_response(latitude,longitude);
                weather.setWeather_info(latitude,longitude);

                Beach beach = new Beach(id,beachinfo,weather,null );
                beaches.add(beach);
                System.out.println(beaches);

            }



            // Pass the beach reviews to the JSP page
            request.setAttribute("beaches", beaches);
            request.getRequestDispatcher("/home.jsp").forward(request, response);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}