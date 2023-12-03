package myclitool;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TextToXML {
    public static @NotNull String convertToXML(String plaintext) throws IOException, InterruptedException {
        String url = "https://www.purgomalum.com/service/xml?text=" + plaintext;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return "<result>" + plaintext + "</result>";
    }
}
