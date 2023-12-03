package myclitool;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class OnlineCompiler {

    public static void compileCode() {
        try {
            // Code and data to be sent
            String code = "#include <stdio.h>\n\nint main() {\n    for (int i = 1; i <= 10; ++i) {\n        printf(\"%d\\n\", i);\n    }\n\n    return 0;\n}";
            String language = "c";
            String input = "";  // You can leave input empty for this example

            // Prepare data for the POST request
            String data = "code=" + code + "&language=" + language + "&input=" + input;
            byte[] postData = data.getBytes(StandardCharsets.UTF_8);

            // API URL
            String apiUrl = "https://api.codex.jaagrav.in";

            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the necessary request method, headers, and parameters
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);

            // Write the data to the connection
            try (OutputStream os = connection.getOutputStream()) {
                os.write(postData);
            }

            // Get the response from the server
            try (Scanner scanner = new Scanner(connection.getInputStream())) {
                StringBuilder response = new StringBuilder();
                while (scanner.hasNextLine()) {
                    response.append(scanner.nextLine());
                }

                // Print the response
                System.out.println(response.toString());
            }

            // Disconnect the connection
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        compileCode();
    }
}
