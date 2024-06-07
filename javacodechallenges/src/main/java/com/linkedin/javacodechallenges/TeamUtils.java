package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
//import java.util.Comparator;
import java.util.Collections;
import java.util.stream.Collectors;

public class TeamUtils {

  record SortedResults(int totalScore, String player1, String player2) {
  }

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  /*
   * private static int sumOfList(List<Integer> list) {
   * return list.stream().mapToInt(i -> i).sum();
   * }
   */

  public static void revealResults(List<Team> teams) {
    System.out.println("Now for the results, the WINNER is...");

    ArrayList<SortedResults> results = new ArrayList<SortedResults>();
    String thenWeHave = "Then we have... \n";
    teams.forEach(team -> {
      int totalScore = team.getScores().stream().mapToInt(n -> n).sum();

      results.add(new SortedResults(
          totalScore,
          team.getPlayer1(),
          team.getPlayer2()));

      // "With " + totalScore + " points, it's team "
      // + team.getPlayer1() + " and " + team.getPlayer2() + "!");
      // System.out.println(team.getScores().stream().mapToInt(n -> n).sum());
    });
    List<SortedResults> sortedResults = results.stream()
        .sorted((o1, o2) -> Integer.valueOf(o2.totalScore)
            .compareTo(Integer.valueOf(o1.totalScore)))
        .collect(Collectors.toList());
    // System.out.println("sortedResults = " + sortedResults);

    // System.out.println("before: " + sortedResults);

    sortedResults.forEach(team -> System.out.println("With " +
        team.totalScore + " points, it's team "
        + team.player1 + " and " + team.player2 + "!\n"));
    System.out.println(thenWeHave);
    // String[] resultsArray = results.toArray(new String[0]);
    // sortedResults.forEach(System.out::println);
    // System.out.println("after: " + sortedResults);

  }
}