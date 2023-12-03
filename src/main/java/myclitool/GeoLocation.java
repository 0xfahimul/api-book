package myclitool;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GeoLocation {
    public static void getGeoLocation(String ipAddress) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://freegeoip.app/json/" + ipAddress))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Geolocation Information for IP " + ipAddress + ":\n" + response.body());
            // Parse and process the response as needed
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}

