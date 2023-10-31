import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AoC1 {

    public static void main(String[] args) {
        String fileName = "AoC1";

        try {
            String[] calories = Files.lines(Paths.get(fileName)).toArray(String[]::new);
            List<Long> sums = new ArrayList<>();
            long sum = 0;

            for (String cal : calories) {
                if (!cal.isEmpty()) {
                    sum += Long.parseLong(cal);
                } else {
                    sums.add(sum);
                    sum = 0;
                }
            }

            Collections.sort(sums);

            System.out.println(sums);

            long firstThreeElf = sums.get(sums.size() - 1) + sums.get(sums.size() - 2) + sums.get(sums.size() - 3);

            System.out.println(firstThreeElf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // functional programming

        try {
            var sums = Arrays.stream(Files.readString(Paths.get(fileName))
                            .split("\n\n"))
                    .map(s -> Arrays.stream(s.split("\n"))
                            .map(t -> Long.parseLong(t))
                            .reduce((x, y) -> (x + y))
                            .orElse(-1L))
                    .sorted((x, y) -> Long.compare(x, y))
                    .toList();

            System.out.println(sums);

            var firstThreeElf = sums.stream()
                    .sorted((x, y) -> Long.compare(y, x))
                    .limit(3)
                    .reduce((x, y) -> (x + y))
                    .orElse(-1L);

            System.out.println(firstThreeElf);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
