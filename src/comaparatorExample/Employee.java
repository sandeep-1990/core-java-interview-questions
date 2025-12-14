package comaparatorExample;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Serializable, Comparable<Employee> {

    int id;
    String name;
    Integer age;
    Double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee emp) {
        return this.age.compareTo(emp.age) + this.salary.compareTo(emp.salary);
    }

   public static final Comparator<Employee> ageComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.age.compareTo(o1.age);
        }
    };

    public static final Comparator<Employee> salaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o2.salary.compareTo(o1.salary);
        }
    };

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
