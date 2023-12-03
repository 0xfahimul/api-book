package myclitool;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;

public class UniversityInfo {

    public static void getUniversityInformation(String country) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://universities.hipolabs.com/search?name=&country=" + country))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response
            JSONArray universitiesArray = new JSONArray(response.body());

            // Process the array of universities
            for (int i = 0; i < universitiesArray.length(); i++) {
                System.out.println("University " + (i + 1) + ": " + universitiesArray.getJSONObject(i).getString("name"));
                // Add more information as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}