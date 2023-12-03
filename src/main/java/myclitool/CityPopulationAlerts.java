package myclitool;

import org.json.JSONArray;
import org.json.JSONObject;

public class CityPopulationAlerts {
    public static void checkCityPopulation(String cityName) {
        try {
            // Your JSON data here

            String jsonData = "[ { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Barisal\", \"a2020\": 483506.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 90.37111, 22.70194 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Bogra\", \"a2020\": 775034.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 89.36667, 24.85 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Chittagong\", \"a2020\": 5019824.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 91.83639, 22.33306 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Comilla\", \"a2020\": 588772.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 91.20444, 23.45778 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Dhaka\", \"a2020\": 21005860.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 90.40744, 23.7104 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Khulna\", \"a2020\": 953745.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 89.56439, 22.80978 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Mymensingh\", \"a2020\": 459983.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 90.4, 24.75 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Rajshahi\", \"a2020\": 907732.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 88.6, 24.36667 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Rangpur\", \"a2020\": 406956.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 89.25, 25.75 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Rupganj\", \"a2020\": 481718.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 90.520591, 23.792554 ] } }, { \"type\": \"Feature\", \"properties\": { \"City_name\": \"Sylhet\", \"a2020\": 851808.0 }, \"geometry\": { \"type\": \"Point\", \"coordinates\": [ 91.87167, 24.89667 ] } } ]";

            JSONArray jsonArray = new JSONArray(jsonData);

            // Search for the city in the dataset
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject cityObject = jsonArray.getJSONObject(i);
                String city = cityObject.getJSONObject("properties").getString("City_name");

                if (city.equalsIgnoreCase(cityName)) {
                    double population = cityObject.getJSONObject("properties").getDouble("a2020");

                    // Determine the alert based on population
                    String alert;
                    if (population < 60000) {
                        alert = "Safe(-60000)";
                    } else if (population < 100000) {
                        alert = "Normal(-100000)";
                    } else {
                        alert = "Heavy(100000+)";
                    }

                    System.out.println("Alert for " + cityName + ": " + alert);
                    return;
                }
            }

            // If the city is not found
            System.out.println("City not found in the dataset.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
