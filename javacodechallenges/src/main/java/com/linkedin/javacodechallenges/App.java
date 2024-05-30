package com.linkedin.javacodechallenges;

public class App {
    public static void main(String[] args) {
        Person forrest = new Person("Gump", "Forrest", 40);
        Person tom = new Person("Shelby", "Thomas", 90);
        Person dick = new Person("Tracy", "Richard", 98);

        try {
            System.out.println(forrest.introduction());
            System.out.println(tom.introduction());
            System.out.println(dick.introduction());
            System.out.println(forrest.toString());
        } catch (IllegalArgumentException e) {
            System.err.println(e.toString());
        }
    }
}
