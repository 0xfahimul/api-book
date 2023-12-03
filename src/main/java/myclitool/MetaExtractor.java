package myclitool;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MetaExtractor {
    public static void extractMeta(String domain) {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://list.ly/api/v4/meta?url=" + domain))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Meta Information for " + domain + ":\n" + response.body());
            // Parse and process the response as needed
        } catch (Exception e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }

    public static void main(String[] args) {
        // Example usage:
        extractMeta("https://example.com");
    }
}
