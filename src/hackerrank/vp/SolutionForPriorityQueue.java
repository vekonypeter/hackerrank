package hackerrank.vp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionForPriorityQueue {

  public static void main(String[] args) {
    Priorities priorities = new Priorities();

    //    List events = Arrays.asList(
    //            "ENTER John 3.75 50",
    //            "ENTER Mark 3.8 24",
    //            "ENTER Shafaet 3.7 35",
    //            "SERVED",
    //            "SERVED",
    //            "ENTER Samiha 3.85 36",
    //            "SERVED",
    //            "ENTER Ashley 3.9 42",
    //            "ENTER Maria 3.6 46",
    //            "ENTER Anik 3.95 49",
    //            "ENTER Dan 3.95 50",
    //            "SERVED"
    //    );

    List events =
        Arrays.asList(
            "ENTER Bidhan 3.75 50",
            "ENTER Rijul 3.8 24",
            "ENTER Shafaet 3.7 35",
            "SERVED",
            "SERVED",
            "ENTER Samiha 3.85 36",
            "SERVED",
            "ENTER Ratul 3.9 42",
            "ENTER Tanvir 3.6 46",
            "ENTER Anik 3.95 49",
            "ENTER Nisha 3.95 50",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED",
            "SERVED");

    List students = priorities.getStudents(events);
    System.out.println(students.size());

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Object st : students) {
        System.out.println(((Student) st));
      }
    }
  }
}

class Student {

  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getID() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public double getCGPA() {
    return this.cgpa;
  }

  public static Student parse(String string) {
    String[] parts = string.split(" ");
    return new Student(Integer.parseInt(parts[2]), parts[0], Double.parseDouble(parts[1]));
  }

  @Override
  public String toString() {
    return "Student{" + "id=" + id + ", name='" + name + '\'' + ", cgpa=" + cgpa + '}';
  }
}

class Priorities {

  private Comparator<Student> studentComparator =
      Comparator.comparing(Student::getCGPA, Comparator.reverseOrder())
          .thenComparing(Student::getName)
          .thenComparing(Student::getID);
  private PriorityQueue<Student> queue = new PriorityQueue<Student>(studentComparator);

  public List<Student> getStudents(List<String> events) {
    events.forEach(
        event -> {
          if ("SERVED".equals(event)) {
            queue.poll();
          } else {
            Student enteringStudent = Student.parse(event.substring(6));
            System.out.println("ADDING:" + enteringStudent.getName());
            queue.add(enteringStudent);
          }
        });

    List<Student> remainingStudents = new ArrayList<Student>(queue);
    remainingStudents.sort(studentComparator);
    return remainingStudents;
  }
}
