package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
//import java.util.Comparator;
//import java.util.Collections;
import java.util.stream.Collectors;

public class TeamUtils {

  record SortedResults(int totalScore, String player1, String player2) {
  }

  private static void printOneResult(SortedResults team) {
    System.out.println("With " + team.totalScore + " points, it's team "
        + team.player1 + " and " + team.player2 + "!");
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

  public static void revealResults(List<Team> teams) {
    ArrayList<SortedResults> results = new ArrayList<SortedResults>();
    String thenWeHave = "Then we have... ";
    HashMap<Integer, Integer> rankTrack = new HashMap<>();
    teams.forEach(team -> {
      int totalScore = team.getScores().stream().mapToInt(n -> n).sum();
      Integer key = Integer.valueOf(totalScore);
      if (!rankTrack.containsKey(key)) {
        rankTrack.put(key, 1);
      } else {
        rankTrack.put(key, rankTrack.get(key) + 1);
      }
      // System.out.println(rankTrack.toString());
      results.add(new SortedResults(
          totalScore,
          team.getPlayer1(),
          team.getPlayer2()));

      // System.out.println(totalScore);
    });
    List<SortedResults> sortedResults = results.stream()
        .sorted((o1, o2) -> Integer.valueOf(o2.totalScore)
            .compareTo(Integer.valueOf(o1.totalScore)))
        .collect(Collectors.toList());

    if (sortedResults.size() > 0 && rankTrack.get(0) == null) {
      System.out.println("Now for the results, the WINNER is...");
      Iterator<SortedResults> iter = sortedResults.iterator();
      while (iter.hasNext()) {
        SortedResults team = iter.next();
        // Let's check rankTrack...
        int teamsAtThisScore = rankTrack.get(team.totalScore);
        if (teamsAtThisScore > 1) {
          System.out.println("It's a TIE!");
          TeamUtils.printOneResult(team);

          while (--teamsAtThisScore > 0) {
            team = iter.next();
            TeamUtils.printOneResult(team);
          }
        } else {
          TeamUtils.printOneResult(team);
        }
        System.out.println();
        if (iter.hasNext()) {
          System.out.println(thenWeHave);
        }
      }
    } else {
      System.out.println("The game hasn't started yet.");
    }
  }
}