import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortString {

    public static void main(String[] args) {
        String str = "sandeep";
        String str1 = "hello";

        String sortedStr = Arrays.stream(str.split("")).sorted().collect(Collectors.joining());
        System.out.println(sortedStr);

        String output  = "";
        for(int i = str1.length()-1; i>=0; i--){
            output += str1.charAt(i);
        }


        System.out.println(output);


        System.out.println(Arrays.stream(str.split("")).sorted().collect(Collectors.joining()));
//        System.out.println(sortedStr);

        List<String> lanList = Arrays.asList("Java","C++","Python","Groov");

        lanList.stream().sorted().forEach(System.out::println);


    }
}
