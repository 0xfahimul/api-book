package myclitool;

import java.util.Scanner;

public class ImageToCharts {
    public static void generateImageChart() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first variable:");
        String variable1 = scanner.nextLine();

        System.out.println("Enter the value for the first variable:");
        int value1 = scanner.nextInt();

        System.out.println("Enter the second variable:");
        String variable2 = scanner.nextLine();  // Consume the newline character
        variable2 = scanner.nextLine();

        System.out.println("Enter the value for the second variable:");
        int value2 = scanner.nextInt();

        // Calculate ratios
        int total = value1 + value2;
        int ratio1 = (int) ((value1 / (double) total) * 100);
        int ratio2 = (int) ((value2 / (double) total) * 100);

        // Generate Image-Charts URL
        String chartUrl = "https://image-charts.com/chart?cht=p3";
        chartUrl += "&chs=300x150";  // You can customize the chart size
        chartUrl += "&chd=t:" + ratio1 + "," + ratio2;
        chartUrl += "&chl=" + variable1 + "|" + variable2;

        System.out.println("Generated Chart URL:");
        System.out.println(chartUrl);
    }

    public static void main(String[] args) {
        // Example usage:
        generateImageChart();
    }
}
