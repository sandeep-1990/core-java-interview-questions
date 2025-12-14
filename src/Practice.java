import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    public static void main(String[] args) {
//        findDuplicate();
//        secondHighestNumber();

//        System.out.println(convertStringIntoNumber());

        reverseString();

//        findCharsCount();

//        gropuByDeptMap();

//        thirdHigestSalry();

//           flatMap();

//        findNonRepeatingWords();
    }


    public static void findDuplicate(){
        Integer[] array = {1, 2, 3, 4, 4, 5, 6, 1, 2};
        Set<Integer> result = new HashSet<>();
        Arrays.stream(array).filter(a -> !result.add(a)).collect(Collectors.toSet());
        System.out.println(result);

        int[] arr = {1, 2, 3, 4, 4, 5, 6, 1, 2};
        Set<Integer> res = new HashSet<>();
        Set<Integer> duplicate  = Arrays.stream(arr).filter(a-> !res.add(a)).boxed().collect(Collectors.toSet());
        System.out.println(duplicate);

    }


    public static void secondHighestNumber() {
        int[] a = {4,6,2,7,9};

        Optional<Integer> result = Arrays.stream(a).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        System.out.println(result.get());

    }

    public static int convertStringIntoNumber(){
        String val = "45678";
        int result = 0;
        for(int i = 0; i<val.length(); i++){
            char c = val.charAt(i);
            int digit = c - '0';
            result = result * 10 + digit;
        }
        return result;

    }

    public static void reverseString(){
        String str = "This is a String";

       /* for(int i = str.length()-1; i>=0; i--){
            System.out.print(str.charAt(i)+ " ");
        }*/

        String reversed = Stream.of(str.split(" ")).map(w -> new StringBuilder(w).reverse().toString()).collect(Collectors.joining(""));
        System.out.println(reversed);

       Optional<String> result = Stream.of(str.split("")).reduce((a,b) -> b+a);
        System.out.println(result.get());
    }

    public static void findCharsCount(){
        String str = "pkkttvvk";

       Map<Character, Long>  result = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(c -> c,Collectors.counting()));
        System.out.println(result);
    }

    public static void gropuByDeptMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("Sandeep", "IT");
        map.put("Manoj", "Account");
        map.put("Aman", "Electric");
        map.put("Sunil", "Account");
        map.put("Ajay", "IT");
        map.put("Sumit", "Electric");


      Map<String, List<String>> result = map.entrySet().stream().collect(Collectors
              .groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())));
        System.out.println(result);
    }

    public static void thirdHigestSalry(){
        Map<String, Double> employeeSalaries = new HashMap<>();
        employeeSalaries.put("Alice", 5000.0);
        employeeSalaries.put("Bob", 6000.0);
        employeeSalaries.put("Charlie", 7000.0);
        employeeSalaries.put("David", 6000.0);
        employeeSalaries.put("Eve", 7000.0);
        employeeSalaries.put("Frank", 8000.0);

        Map<Double, List<String>> groupMap =  employeeSalaries.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey,Collectors.toList())));

        Set<Double> salaries = groupMap.keySet().stream().sorted().collect(Collectors.toSet());

        Optional<Double> highSalary =  salaries.stream().skip(2).findFirst();

        System.out.println(groupMap);
        System.out.println(salaries);
        System.out.println(highSalary.get());

    }

    public static void flatMap(){
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );

        List<Integer> singleResult = listOfLists.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(singleResult);
    }

    public static void findNonRepeatingWords(){
        String str = "sandeep";

       List<Character> nonRepeating = str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(ch -> ch,LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(Map.Entry::getKey).toList();
        System.out.println(nonRepeating);
    }

}
