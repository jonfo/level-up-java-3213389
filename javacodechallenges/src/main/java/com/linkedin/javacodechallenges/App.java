package com.linkedin.javacodechallenges;

import java.util.List;

public class App {

    public static double calculateAverageChangeInvested(List<Double> purchases) {
        double avgDiff = 0.0;
        if (purchases.size() > 0) {
            avgDiff = purchases.stream()
                //.mapToDouble(d -> Math.ceil(d) - d).average().orElse(0);
                .mapToDouble(d -> Math.ceil(d) - d).sum() / purchases.size();
        }
        /*
        avgDiff = purchases.stream()
                .mapToDouble(d -> Math.ceil(d) - d).average().orElse(0);
        */       
        return avgDiff;
    }

    public static void main(String[] args) {
        List<Double> purchases = List.of(12.38, 38.29, 5.27, 3.21);
        System.out.println(calculateAverageChangeInvested(purchases));
    }
}
