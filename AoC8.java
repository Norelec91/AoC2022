import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class AoC8 {
    public static void main(String[] args) {
        String fileName = "AoC8";

        try {
            var lines = Arrays.stream(Files.readString(Paths.get(fileName))
                            .split("\n"))
                    .map(x -> Arrays.stream(x.split(""))
                            .map(Integer::parseInt)
                            .toArray(Integer[]::new))
                    .toArray(Integer[][]::new);

            for (int i = 0; i < lines.length; i++) {
                for (int j = 0; j < lines.length; j++) {
                    if (i >= 0) {

                    }
                }

                System.out.println("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
