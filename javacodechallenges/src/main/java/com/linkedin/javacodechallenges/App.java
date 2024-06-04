package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.Objects;

public class App {
  public static final Map<Character, Integer> letterPoints = Map.ofEntries(Map.entry('A', 1),
      Map.entry('B', 3), Map.entry('C', 3), Map.entry('D', 2), Map.entry('E', 1),
      Map.entry('F', 4), Map.entry('G', 2), Map.entry('H', 4), Map.entry('I', 1),
      Map.entry('J', 8), Map.entry('K', 5), Map.entry('L', 1), Map.entry('M', 3),
      Map.entry('N', 1), Map.entry('O', 1), Map.entry('P', 3), Map.entry('Q', 10),
      Map.entry('R', 1), Map.entry('S', 1), Map.entry('T', 1), Map.entry('U', 1),
      Map.entry('W', 4), Map.entry('V', 4), Map.entry('X', 8), Map.entry('Y', 4),
      Map.entry('Z', 10));

  public static boolean checkCharValid(Character c) {

    Set<Character> validKeys = letterPoints.keySet();

    if (!validKeys.contains(c)) {
      System.out.println("Warning: invalid character in string: '" + c + "'");
      return false;
    }
    return true;
  }

  public static int wordScoreCalculator(String word) {

    // Create a set of valid keys.
    // Set<Character> validKeys = letterPoints.keySet();

    // Split up word into a list of 1 char strings.
    // Also, upcase the alphabetic chars.
    List<Character> chars = word.toUpperCase().chars().mapToObj(e -> (char) e)
        // .filter(c -> validKeys.contains(c))
        .filter(c -> checkCharValid(c))
        .collect(Collectors.toList());

    return chars.stream().mapToInt(i -> letterPoints.get(i)).sum();
  }

  public static void main(String[] args) {
    System.out.println("Enter a word and we'll tell you how many " +
        "points it will earn!");
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();
    System.out.println("Your word " + word + " will earn "
        + wordScoreCalculator(word));
    sc.close();
  }

}
