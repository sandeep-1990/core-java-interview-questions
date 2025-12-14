package EmployeeGroupByPractice;

import comaparatorExample.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThirdHighesSalaryWithMap {

    public static void main(String[] args) {
        Map<String, Double> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Alice", 5000.0);
        employeeSalaries.put("Bob", 6000.0);
        employeeSalaries.put("Charlie", 7000.0);
        employeeSalaries.put("David", 6000.0);
        employeeSalaries.put("Eve", 7000.0);
        employeeSalaries.put("Frank", 8000.0);


        Map<Double, List<String>> groupMap = employeeSalaries.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())));

        groupMap.keySet().stream().sorted(Comparator.reverseOrder());

        System.out.println(groupMap);

        groupMap.entrySet().stream().skip(2).findFirst().stream().forEach(System.out::println);

    }

}
