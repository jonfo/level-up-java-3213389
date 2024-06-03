package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class App {
  public static final Map<Character, Integer> letterPoints = Map.ofEntries(Map.entry('A', 1),
      Map.entry('B', 3), Map.entry('C', 3), Map.entry('D', 2), Map.entry('E', 1),
      Map.entry('F', 4), Map.entry('G', 2), Map.entry('H', 4), Map.entry('I', 1),
      Map.entry('J', 8), Map.entry('K', 5), Map.entry('L', 1), Map.entry('M', 3),
      Map.entry('N', 1), Map.entry('O', 1), Map.entry('P', 3), Map.entry('Q', 10),
      Map.entry('R', 1), Map.entry('S', 1), Map.entry('T', 1), Map.entry('U', 1),
      Map.entry('W', 4), Map.entry('V', 4), Map.entry('X', 8), Map.entry('Y', 4),
      Map.entry('Z', 10));

  public static int wordScoreCalculator(String word) {
    // Split up word into a list of 1 char strings
    // List<Character> chars = new ArrayList<>();
    List<Character> chars = word.chars().mapToObj(e -> (char) e)
        .collect(Collectors.toList());

    // for (char ch : word.toCharArray()) {
    // chars.add(Character.toUpperCase(ch));
    // }

    final int points = 0;
    System.out.println(letterPoints.get('Z'));
    chars.forEach(ch -> System.out.println("word: " + ch));

    // int points = chars.forEach()
    // .filter(ch -> (App.letterPoints.containsKey(ch)))
    // .collector(Collectors.summingInt());

    // System.out.println("word = " + word + ":, " + word.chars());
    return points;
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
