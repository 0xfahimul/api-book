package myclitool;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProfanityChecker {
    private static Set<String> profanityWords;

    static {
        // Initialize the profanity word list
        profanityWords = new HashSet<>();
        profanityWords.add("arse");
        profanityWords.add("arsehole");
        profanityWords.add("shit");
        profanityWords.add("whore");
        // Add more profanity words to the set...
    }

    public static boolean containsProfanity(String sentence) {
        String[] words = sentence.toLowerCase().split("\\s+");

        for (String word : words) {
            if (profanityWords.contains(word)) {
                return true;
            }
        }

        return false;
    }

    public static void checkProfanity() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a sentence to check for profanity:");
        String inputSentence = scanner.nextLine();

        if (containsProfanity(inputSentence)) {
            System.out.println("Profanity detected!");
        } else {
            System.out.println("No profanity found.");
        }
    }
}
