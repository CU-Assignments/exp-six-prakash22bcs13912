import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 25, 50000));
        employees.add(new Employee("Bob", 30, 60000));
        employees.add(new Employee("Charlie", 22, 45000));
        employees.add(new Employee("David", 35, 70000));
        employees.add(new Employee("Eva", 28, 55000));

        // Sorting by name
        Collections.sort(employees, Comparator.comparing(emp -> emp.name));
        System.out.println("Sorted by name:");
        System.out.println(employees);

        // Sorting by age
        Collections.sort(employees, Comparator.comparingInt(emp -> emp.age));
        System.out.println("\nSorted by age:");
        System.out.println(employees);

        // Sorting by salary
        Collections.sort(employees, Comparator.comparingDouble(emp -> emp.salary));
        System.out.println("\nSorted by salary:");
        System.out.println(employees);
    }
}
