package myclitool;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CryptoPrice {
    public static void viewCryptoPrices() {
        HttpClient client = HttpClient.newHttpClient();

        // List of cryptocurrency IDs (e.g., bitcoin, ethereum, litecoin, etc.)
        String[] cryptoIds = {"bitcoin", "ethereum", "litecoin", "ripple", "cardano", "polkadot", "chainlink", "stellar", "dogecoin", "tezos"};

        for (String cryptoId : cryptoIds) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.coingecko.com/api/v3/simple/price?ids=" + cryptoId + "&vs_currencies=usd"))
                    .build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println("Crypto: " + cryptoId + " - Price: " + response.body());
                // Parse and process the response as needed
            } catch (Exception e) {
                e.printStackTrace();
                // Handle exceptions
            }
        }
    }

    public static void main(String[] args) {
        viewCryptoPrices();
    }
}
