package EmployeeGroupByPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

    private String name;
    private String department;

    // Constructor, getters, and setters

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "IT"),
                new Employee("David", "HR"),
                new Employee("Eve", "Finance")
        );

        employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((department,count)->System.out.println(department+" "+count));
//        collect.forEach((department,count)-> System.out.println(department+" "+count));
    }
}
