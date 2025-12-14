import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Stream;

public class ExecuteStringArray {
    public static void main(String[] args) {

        String[] str = {"Sandeep","Sahil","Aman"};

        Arrays.stream(str).forEach(System.out::println);

        Stream.of(str).forEach(System.out::println);
    }
}
