package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Map;

/* non-stream
 * import java.util.ArrayList;
 * import java.util.ListIterator;
 * import java.util.HashMap;
 */
/* stream */
import java.util.stream.Collectors;

public class App {
  public static List<String> findStudentsWithIncompleteVolunteerEvents(
      List<String> students,
      Map<String, List<String>> attendeesMapping) {

    /*
     * non-stream
     * // This map will keep track of the student's events attendance.
     * Map<String, Integer> assocMap = new HashMap<String, Integer>();
     * for (ListIterator<String> student = students.listIterator();
     * student.hasNext();) {
     * assocMap.put(student.next(), 0);
     * }
     */
    /* stream */
    // Uses Collectors.toMap to build the Map.
    Map<String, Integer> assocMap = students.stream().collect(Collectors.toMap(s -> s, n -> 0));

    // For each event in attendeesMapping,
    // using only students in the assocMap map
    // For each student at the event (that are in the assocMap)
    // Increment the count for that student in the assocMap
    attendeesMapping.values()
        .forEach(list -> list.stream()
            .filter(student -> assocMap.containsKey(student))
            .forEach(studentAtEvt -> assocMap.put(studentAtEvt, assocMap.get(studentAtEvt) + 1)));

    // Let's see what the assocMap looks like now...
    // System.out.println("assocMap now contains " + assocMap.toString());

    /*
     * non-stream
     * for (Map.Entry<String, List<String>> entry : attendeesMapping.entrySet()) {
     * for (ListIterator<String> student = students.listIterator();
     * student.hasNext();) {
     * String name = student.next();
     * if (entry.getValue().contains(name)) {
     * int count = assocMap.get(name);
     * assocMap.put(name, count + 1);
     * }
     * }
     * }
     *
     * non-stream
     * List<String> lazyStudents = new ArrayList<String>();
     * for (var entry : assocMap.entrySet()) {
     * if (entry.getValue() < 2) {
     * lazyStudents.add(entry.getKey());
     * }
     * }
     * return lazyStudents;
     */

    /* stream */
    // Get a stream of the assocMap
    // filter out all entries with values >= 2
    // map to a new stream that only contains the key values for the filtered
    // entries
    // uses collect(Collectors.toList() to return a list of the key values.
    return assocMap.entrySet().stream().filter(evtCnt -> evtCnt.getValue() < 2).map(m -> m.getKey())
        .collect(Collectors.toList());

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
