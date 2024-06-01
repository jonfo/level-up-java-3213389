package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class App {
  public static List<String> findStudentsWithIncompleteVolunteerEvents(
      List<String> students,
      Map<String, List<String>> attendeesMapping) {

    // This map will keep track of the student's events attendance.
    Map<String, Integer> assocMap = new HashMap<String, Integer>();
    for (ListIterator<String> student = students.listIterator(); student.hasNext();) {
      assocMap.put(student.next(), 0);
    }

    for (Map.Entry<String, List<String>> entry : attendeesMapping.entrySet()) {
      for (ListIterator<String> student = students.listIterator(); student.hasNext();) {
        String name = student.next();
        if (entry.getValue().contains(name)) {
          int count = assocMap.get(name);
          assocMap.put(name, count + 1);
        }
      }
    }

    List<String> lazyStudents = new ArrayList<String>();
    for (var entry : assocMap.entrySet()) {
      if (entry.getValue() < 2) {
        lazyStudents.add(entry.getKey());
      }
    }
    return lazyStudents;
  }

  public static void main(String[] args) {
    List<String> students = List.of("Sally", "Polly", "Molly",
        "Tony", "Harry");

    Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
        "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
        "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
        "Midnight Breakfast", List.of("Polly", "Molly"));

    System.out.println(findStudentsWithIncompleteVolunteerEvents(
        students, attendeesMapping));
  }

}
