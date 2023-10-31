import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class AoC6 {

    public static void main(String[] args) {
        String fileName = "AoC6";

        try {
            var buffer = Arrays.stream(Files.readString(Paths.get(fileName)).split("")).toList();

            for (int i = 0; i < buffer.size(); i++) {
                var window = buffer.subList(i, i + 4);
                var characterSet = window.stream().collect(Collectors.toSet());

                if (characterSet.size() == 4) {
                    System.out.println(i + 4);

                    break;
                }
            }

            for (int i = 0; i < buffer.size(); i++) {
                var window = buffer.subList(i, i + 14);
                var characterSet = window.stream().collect(Collectors.toSet());

                if (characterSet.size() == 14) {
                    System.out.println(i + 14);

                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
