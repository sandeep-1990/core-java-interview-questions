package comaparatorExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();

        Employee e1 = new Employee(1, "Sandeep Singh", 32, 20000);
        Employee e2 = new Employee(1, "Amandeep Singh", 31, 30000);
        Employee e3 = new Employee(1, "GurSehaj Singh", 33, 40000);

        empList.add(e1);
        empList.add(e2);
        empList.add(e3);
       /* Collections.sort(empList,Employee.ageComparator);
        System.out.println(empList);

        Collections.sort(empList,Employee.salaryComparator);
        System.out.println(empList);*/

//       List<Employee> sortedList =  empList.stream().sorted(Comparator.comparing(Employee::getAge).reversed().thenComparing(Comparator.comparing(Employee::getSalary))).collect(Collectors.toList());
//        sortedList.forEach(System.out::println);

        empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
    }
}
