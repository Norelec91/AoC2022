import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AoC4 {

    public static void main(String[] args) {
        String fileName = "AoC4";

        try {
            var count = Arrays.stream(Files.readString(Paths.get(fileName))
                            .split("\n"))
                    .map(s -> Arrays.stream(s.split(","))
                            .map(t -> Arrays.stream(t.split("-"))
                                    .map(Integer::parseInt)
                                    .toList())
                            .map(t -> IntStream.range(t.get(0), t.get(1) + 1)
                                    .boxed()
                                    .collect(Collectors.toSet()))
                            .toList())
                    .map(s -> s.get(0).containsAll(s.get(1)) || s.get(1).containsAll(s.get(0)))
                    .filter(s -> s)
                    .count();

            System.out.println(count);

            count = Arrays.stream(Files.readString(Paths.get(fileName))
                            .split("\n"))
                    .map(s -> Arrays.stream(s.split(","))
                            .map(t -> Arrays.stream(t.split("-"))
                                    .map(Integer::parseInt)
                                    .toList())
                            .map(t -> IntStream.range(t.get(0), t.get(1) + 1)
                                    .boxed()
                                    .collect(Collectors.toSet()))
                            .toList())
                    .map(s -> s.get(0).stream()
                            .anyMatch(t -> s.get(1).contains(t)))
                    .filter(s -> s)
                    .count();

            System.out.println(count);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
