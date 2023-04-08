package com.example.mybeachspot;

import java.net.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.*;

public class Api_response {
   public static void main(String[] args) {
      try {
         // Create a URL object for the API endpoint
         
    	  Double latitude = 44.34;
    	  Double longitude = 10.99;
    	  String key="70db48721905b47531363ef5647ef5b8";
    	  
    	  
    	  URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+ latitude +"&lon="+ longitude +"&appid="+key);

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
         // Print the API response
         System.out.println(temp);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
