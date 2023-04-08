package com.example.mybeachspot;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Api_beach_response {
  public static void main(String[] args) throws IOException {
    String url = "https://api.coastal.ca.gov/access/v1/locations";
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
    con.setRequestMethod("GET");
    con.connect();
    int responseCode = con.getResponseCode();

    if (responseCode == 200) { // success
      Scanner scanner = new Scanner(con.getInputStream());
      String responseBody = scanner.useDelimiter("\\A").next();
      scanner.close();

      JSONArray jsonArray = new JSONArray(responseBody);
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject jsonObject = jsonArray.getJSONObject(i);
        int id = jsonObject.getInt("ID");
        if (id == 1) {
          String locationMobileWeb = jsonObject.getString("LocationMobileWeb");
          System.out.println("LocationMobileWeb for ID 1: " + locationMobileWeb);
          break; // exit the loop after finding the object with ID 1
        }
      }
    } else {
      System.out.println("Failed to get data. Response code: " + responseCode);
    }
  }
}