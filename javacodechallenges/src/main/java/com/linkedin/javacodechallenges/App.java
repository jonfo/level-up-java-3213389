package com.linkedin.javacodechallenges;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
//import java.util.Optional;

public class App {
    public static List<String> redactTextFile(String fileName,
            String[] redactedWordsArray) throws FileNotFoundException, IOException {
        // Not sure if this is a legitimate use of FileNotFoundException...
        if (fileName == null || fileName == "")
            throw new FileNotFoundException("No filename specified");
        /*
         * System.out.println("File to redact: " + fileName);
         * System.out.println("Redacted words list: " +
         * Arrays.toString(redactedWordsArray));
         */
        ArrayList<String> redactedText = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        String rex = "(?i)" + String.join("|", redactedWordsArray);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String outLine = line.replaceAll(rex, "REDACTED");
            redactedText.add(outLine);
            // redactedText.forEach(s -> System.out.println("debug: " + s));
        }
        sc.close();
        return redactedText;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "redact information from?");
        String fileName = scanner.nextLine();

        System.out.println("What words would you like to redact? " +
                "Separate each word or phrase with a comma. " +
                "If you phrase includes punctuation, include " +
                "that in your input.");
        String redactedWords = scanner.nextLine();
        String[] redactedWordsList = redactedWords.split(",");

        try {
            List<String> result = redactTextFile(fileName, redactedWordsList);
            result.forEach(s -> System.out.println("output: " + s));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}
