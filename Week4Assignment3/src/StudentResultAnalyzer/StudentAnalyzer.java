package StudentResultAnalyzer;

import java.util.*;

public class StudentAnalyzer {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Dhiraj", 78));
        students.add(new Student("Aditya", 92));
        students.add(new Student("Rohit", 65));
        students.add(new Student("Aman", 88));
        students.add(new Student("Sneha", 74));
        students.add(new Student("Priya", 95));
        students.add(new Student("Rahul", 69));
        students.add(new Student("Neha", 82));
        students.add(new Student("Vikas", 90));
        students.add(new Student("Pooja", 71));
        


        List<Student> sortedStudents = students.stream().sorted(Comparator.comparingInt(Student::marks)).toList();

        System.out.println("Topper Marks: " + sortedStudents.getLast());

        System.out.println("Lowest Marks: " + sortedStudents.getFirst());

        System.out.println("Reversed Marks: " + sortedStudents.reversed());
    }
}
