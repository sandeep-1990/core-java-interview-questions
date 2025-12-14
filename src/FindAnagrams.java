import java.util.stream.Collectors;

public class FindAnagrams {

    public static void main(String[] args) {

        String str1 = "ABC";
        String str2 = "CBA";

        boolean isAnagram = str1.chars().sorted().mapToObj(c -> String.valueOf((char)c)).collect(Collectors.joining())
                .equals(str2.chars().sorted().mapToObj(c2 -> String.valueOf((char)c2)).collect(Collectors.joining()));

        System.out.println(isAnagram);


    }


}
