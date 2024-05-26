package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static final double CCF = 748.0;
    public static final double ADDL_CCF_CHG = 3.90;

    public static double calculateWaterBill(double gallonsUsage) {
        double bill = 18.84;
        if (gallonsUsage > CCF * 2) {
            // Calculate num additional gallons
            double overage = gallonsUsage - CCF * 2;
            // Calculate the number of additional CCFs
            long numAddlCCFs = (long) Math.ceil(overage / CCF);
            bill += (double) (numAddlCCFs * ADDL_CCF_CHG);
        }
        return bill;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
