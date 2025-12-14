import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

public class ReadLargeFile {

    public static void main(String[] args) {
        Stream<String> lines = null;
        int count = 0;
        try{
            lines = Files.lines(Paths.get("C:\\Users\\VICTUS\\Downloads\\large_test_file.txt"));
            Instant start = Instant.now();
            lines.forEach(System.out::println);
            Instant end = Instant.now();
            Duration duration = Duration.between(start,end);
            System.out.println(duration.getSeconds());
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }finally {
             if(lines != null){
               lines.close();
             }
        }
    }

}
