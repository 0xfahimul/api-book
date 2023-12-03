package myclitool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CloudflareInfo {
    public static String getCloudflareInfo() {
        try {
            // URL for the Cloudflare endpoint
            String url = "https://1.1.1.1/cdn-cgi/trace";

            // Creating a URL object
            URL obj = new URL(url);

            // Creating an HTTPURLConnection
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            // Setting the request method to GET
            connection.setRequestMethod("GET");

            // Getting the response code
            int responseCode = connection.getResponseCode();

            // Reading the response
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Returning the response
                return response.toString();
            } else {
                System.out.println("Error: Unable to fetch Cloudflare information. HTTP Status: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
