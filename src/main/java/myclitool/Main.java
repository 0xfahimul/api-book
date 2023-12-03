package myclitool;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static String encodeValue(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. City Population Alerts");
            System.out.println("2. My Info");
            System.out.println("3. Online Compiler");
            System.out.println("4. Tools");
            System.out.println("5. Technologies & Information");
            System.out.println("7. View User History");
            System.out.println("0. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the city name:");
                    String cityName = scanner.nextLine();
                    CityPopulationAlerts.checkCityPopulation(cityName);
                    break;
                case 2:
                    System.out.println("Choose an option:");
                    System.out.println("    2.1 Cloudflare Information");
                    System.out.println("    2.2 My IP Information");

                    int myInfoChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (myInfoChoice) {
                        case 1:
                            String cloudflareInfoResponse = CloudflareInfo.getCloudflareInfo();
                            System.out.println("Cloudflare Information:");
                            System.out.println(cloudflareInfoResponse);
                            break;
                        case 2:
                            String ipInformationResponse = IPInformation.getIPInformation();
                            System.out.println("IP Information:");
                            System.out.println(ipInformationResponse);
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                    }
                    break;
                case 3:
                    System.out.println("Enter your C code:");
                    String code = scanner.nextLine();

                    String language = "c";
                    String input = "";  // You can leave input empty for this example

                    String encodedCode = encodeValue(code);
                    String encodedInput = encodeValue(input);

                    String data = "code=" + encodedCode + "&language=" + language + "&input=" + encodedInput;

                    String url = "https://api.codex.jaagrav.in";

                    try {
                        String response = CompilerUtils.compileCode(url, data);
                        System.out.println("Compilation Result:\n" + response);
                    } catch (Exception e) {
                        System.out.println("Error during compilation: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Choose an option:");
                    System.out.println("    4.1 Profanity Checker");
                    System.out.println("    4.2 Text to Chart");
                    System.out.println("    4.3 Text to JSON");
                    System.out.println("    4.4 Text to XML");
                    System.out.println("    4.5 Random String Generator");

                    int toolsChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (toolsChoice) {
                        case 1:
                            ProfanityChecker.checkProfanity();
                            break;
                        case 2:
                            ImageToCharts.generateImageChart();
                        case 3:
                            System.out.println("Enter your plain text:");
                            String plainText = scanner.nextLine();
                            try {
                                String jsonResult = TextToJSON.convertToJSON(plainText);
                                System.out.println("JSON Result:\n" + jsonResult);
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Error converting to JSON: " + e.getMessage());
                            }
                            break;

                        case 4:
                            System.out.println("Enter your plain text:");
                            String plainTextXML = scanner.nextLine();
                            try {
                                String xmlResult = TextToXML.convertToXML(plainTextXML);
                                System.out.println("XML Result:\n" + xmlResult);
                            } catch (IOException | InterruptedException e) {
                                System.out.println("Error converting to XML: " + e.getMessage());
                            }
                            break;


                        case 5:
                            System.out.println("Enter the length of each random string:");
                            int length = scanner.nextInt();

                            System.out.println("Enter the number of random strings to generate:");
                            int count = scanner.nextInt();

                            List<String> randomStrings = RandomStringGenerator.generateRandomStrings(length, count);

                            // Print the generated random strings
                            System.out.println("Generated Random Strings:");
                            for (String randomString : randomStrings) {
                                System.out.println(randomString);
                            }
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                    }
                    break;
                case 5:
                    System.out.println("Choose an option:");
                    System.out.println("    5.1 CryptoCurrency Prices (Not implemented in this demo)");
                    System.out.println("    5.2 Country-based University Information");
                    System.out.println("    5.3 Meta Info");
                    System.out.println("    5.4 Geolocation from IP");
                    System.out.println("    5.5 Movies Information");
                    System.out.println("    5.6 Weather Information");

                    int techChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (techChoice) {
                        case 1:
                            CryptoPrice.viewCryptoPrices();
                            break;
                        case 2:
                            System.out.println("Enter the country name:");
                            String country = scanner.nextLine();
                            UniversityInfo.getUniversityInformation(country);
                            break;

                        case 3:
                            System.out.println("Enter the website domain:");
                            String websiteDomain = scanner.nextLine();
                            MetaExtractor.extractMeta(websiteDomain);
                            break;

                        case 4:
                            System.out.println("Enter the IP address:");
                            String ipAddress = scanner.nextLine();
                            GeoLocation.getGeoLocation(ipAddress);
                            break;
                        default:
                            System.out.println("Invalid option. Please choose a valid option.");
                    }
                    break;
                case 6:
                    System.out.println("Viewing user history... (Not implemented in this demo)");
                    break;
                case 0:
                    System.out.println("Logging out.");
                    currentUser = null;
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
