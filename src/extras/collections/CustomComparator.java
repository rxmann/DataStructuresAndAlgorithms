import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomComparator {

    // Must be static to be used in main
    static class Student {
        String name;
        int grade;

        Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name + " (" + grade + ")";
        }
    }

    // Must be static to be instantiated in main
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
        }
    }

    static class GradeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            // Ascending order
            return s1.grade - s2.grade;
        }
    }

    public static void main(String[] args) {
        // 1. Initialize the List
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 85));
        students.add(new Student("Charlie", 92));
        students.add(new Student("Bob", 78));

        System.out.println("Original: " + students);

        // 2. Sort by Name using our custom Comparator
        Collections.sort(students, new NameComparator());
        System.out.println("Sorted by Name: " + students);

        // 3. Sort by Grade using our custom Comparator
        Collections.sort(students, new GradeComparator());
        System.out.println("Sorted by Grade: " + students);
    }
}
