package com.example.mybeachspot;

import java.awt.image.BufferedImage;
import java.net.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import java.io.*;
import java.util.ArrayList;

public class Api_response {
   Double latitude;
   Double longitude;

   String temp;
   String wind;
   String description;

   public Double getLatitude() {
      return latitude;
   }

   public String getTemp() {
      return temp;
   }

   public void setTemp(String temp) {
      this.temp = temp;
   }

   public String getWind() {
      return wind;
   }

   public void setWind(String wind) {
      this.wind = wind;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public void setLatitude(Double latitude) {
      this.latitude = latitude;
   }

   public void setLongitude(Double longitude) {
      this.longitude = longitude;
   }

   public Double getLongitude() {
      return longitude;
   }



   public Api_response(Double latitude, Double longitude) {
      this.latitude = latitude;
      this.longitude = longitude;
   }

   @Override
   public String toString() {
      return
              "latitude=" + latitude +
              ", longitude=" + longitude +
              ", temp='" + temp + '\'' +
              ", wind='" + wind + '\'' +
              ", description='" + description + '\'' +
              '}';
   }

   public void setWeather_info(Double latitude, Double longitude) {
      try {
         // Create a URL object for the API endpoint
    	  String key="70db48721905b47531363ef5647ef5b8";

    	  
    	  URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+ latitude +"&lon="+longitude+"&appid=70db48721905b47531363ef5647ef5b8");

         // Create a HttpURLConnection object
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");

         // Read the API response
         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         String inputLine;
         StringBuffer response = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
         }
         in.close();
         
         String resText = response.toString();
         Gson gson = new Gson();
         JsonObject jsonObject = gson.fromJson(resText, JsonObject.class);
        
         String temp = ((JsonObject) jsonObject.get("main")).get("temp").getAsString();
         String wind = ((JsonObject) jsonObject.get("wind")).get("speed").getAsString();

         JsonArray weatherArray = jsonObject.getAsJsonArray("weather");
         JsonObject weatherObject = (JsonObject) weatherArray.get(0);
         String description = weatherObject.get("description").getAsString();

         this.temp=temp;
         this.wind=wind;
         this.description=description;
         // Print the API response
         System.out.println(temp);
         System.out.println(wind);
         System.out.println(description);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
