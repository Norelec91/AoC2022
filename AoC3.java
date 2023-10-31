import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AoC3 {

    public static void main(String[] args) {
        String fileName = "AoC3";

        try {
            String[] rows = Arrays.stream(Files.readString(Paths.get(fileName))
                    .split("\n"))
                    .toArray(String[]::new);

            long sum = 0;

            for (String row : rows) {
                int halfLength = row.length() / 2;
                List<String> compartment1 = new ArrayList<>(Arrays.asList(row.substring(0, halfLength).split("")));
                List<String> compartment2 = new ArrayList<>(Arrays.asList(row.substring(halfLength).split("")));

                compartment1.retainAll(compartment2);

                char item = compartment1.get(0).charAt(0);
                int priority = Character.isLowerCase(item) ? item - 96 : item - 64 + 26;

//                    System.out.println(item + " ---> " + priority);

                sum += priority;
            }

            System.out.println(sum);

            sum = 0;

            String s1 = "";
            String s2 = "";
            String s3 = "";

            for (int i = 0; i < rows.length; i++) {
                if (s1.isEmpty()) {
                    s1 = rows[i];

                    continue;
                }

                if (!s1.isEmpty() && s2.isEmpty()) {
                    s2 = rows[i];

                    continue;
                }

                if (!s1.isEmpty() && !s2.isEmpty() && s3.isEmpty()) {
                    s3 = rows[i];

                    List<String> compartment1 = new ArrayList<>(Arrays.asList(s1.split("")));
                    List<String> compartment2 = new ArrayList<>(Arrays.asList(s2.split("")));
                    List<String> compartment3 = new ArrayList<>(Arrays.asList(s3.split("")));

                    compartment1.retainAll(compartment2);
                    compartment1.retainAll(compartment3);

                    char item = compartment1.get(0).charAt(0);
                    int priority = Character.isLowerCase(item) ? item - 96 : item - 64 + 26;

                    sum += priority;

                    s1 = s2 = s3 = "";
                }
            }

            System.out.println(sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
