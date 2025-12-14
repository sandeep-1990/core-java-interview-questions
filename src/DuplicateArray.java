import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateArray {

    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 4, 5, 6, 1, 2};

        Set<Integer> set = new HashSet<Integer>();
//        Arrays.stream(array).filter(a -> !set.add(a)).collect(Collectors.toSet()).forEach(System.out::println);

        int[] ar = {1, 2, 3, 4, 4, 5, 6, 1, 2};

        Arrays.stream(ar).filter(a -> !set.add(a)).boxed().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println(set);
    }

}
