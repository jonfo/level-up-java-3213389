package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class DoubleOrNothing {

  protected boolean rollDice() {
    double randval = Math.random();
    return (randval >= 0.5);
  }

  public void playGame() {
    int points = 10;
    try (Scanner scanner = new Scanner(System.in)) {
      boolean winning = true;
      while (winning) {
        System.out.println("Double or Nothing");
        System.out.println("You currently have " + points + " points");
        System.out.println("You can keep your points and leave,");
        System.out.print("or take a chance and double your money. Y/N? ");
        String yorn = scanner.nextLine().toUpperCase();
        if (yorn.equals("Y")) {
          if (rollDice()) {
            points += points;
            System.out.println("You lucked out!");
          } else {
            System.out.println("Yout lost it all.  Better luck next time!");
            System.exit(1);
          }
        }
      }
    }
  }
}