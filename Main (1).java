import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + ", " + marks;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 88.5));
        students.add(new Student("Bob", 72.0));
        students.add(new Student("Charlie", 78.0));
        students.add(new Student("David", 90.0));
        students.add(new Student("Eva", 65.0));

        // Filter students scoring above 75%, sort by marks, and display their names
        List<String> filteredAndSortedStudents = students.stream()
                .filter(student -> student.marks > 75)
                .sorted(Comparator.comparingDouble(student -> student.marks))
                .map(student -> student.name)
                .collect(Collectors.toList());

        System.out.println("Students scoring above 75%, sorted by marks:");
        filteredAndSortedStudents.forEach(System.out::println);
    }
}
