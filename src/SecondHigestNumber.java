import java.util.Arrays;
import java.util.Comparator;

public class SecondHigestNumber {

    public static void main(String[] args) {
        int[] a = {4,6,2,7,9};
        int size =a.length;
        Arrays.sort(a);
        int result = a[size-2];
        System.out.println(result);

        Arrays.stream(a).distinct().sorted().skip(a.length-2).findFirst();

    }

}
