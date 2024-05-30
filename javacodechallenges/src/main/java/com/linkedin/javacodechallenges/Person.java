package com.linkedin.javacodechallenges;

public class Person {
  private String lname;
  private String fname;
  private int age;

  public static final int MAX_AGE = 150;
  public static final int MIN_AGE = 1;

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age >= MIN_AGE & age <= MAX_AGE)
      this.age = age;
    else
      throw new IllegalArgumentException("Value must be between " + MIN_AGE + " and " + MAX_AGE);
  }

  public String introduction() {
    String greeting = String.format("Hi, my name's %s %s. People call me %s %s.",
        this.fname, this.lname, this.fname, this.lname);
    return greeting;
  }

  public String toString() {
    return ("lname = " + lname + "\n" + "fname = " + fname + "\n" + "age = " + age);
  }

  public Person(String lname, String fname, int age) {
    this.lname = lname;
    this.fname = fname;
    this.age = age;
  }

}