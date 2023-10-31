import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoC2 {

    public static void main(String[] args) {
        String fileName = "AoC2";

        try {
            String[] rows = Arrays.stream(Files.readString(Paths.get(fileName))
                    .split("\n"))
                    .toArray(String[]::new);

            String[] enemyMoves = Arrays.stream(rows)
                    .map(s -> s.split(" ")[0])
                    .toArray(String[]::new);

            String[] myMoves = Arrays.stream(rows)
                    .map(s -> s.split(" ")[1])
                    .toArray(String[]::new);

            long points = 0;

            for (int i = 0; i < rows.length; i++) {
                switch (enemyMoves[i]) {

                }
                if (enemyMoves[i].equals("A") && myMoves[i].equals("X")) {
                    points += 1 + 3;
                } else if (enemyMoves[i].equals("A") && myMoves[i].equals("Y")) {
                    points += 2 + 6;
                } else if (enemyMoves[i].equals("A") && myMoves[i].equals("Z")) {
                    points += 3;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("X")) {
                    points += 1;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("Y")) {
                    points += 2 + 3;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("Z")) {
                    points += 3 + 6;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("X")) {
                    points += 1 + 6;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("Y")) {
                    points += 2;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("Z")) {
                    points += 3 + 3;
                }
            }

            System.out.println(points);

            points = 0;

            for (int i = 0; i < rows.length; i++) {
                if (enemyMoves[i].equals("A") && myMoves[i].equals("X")) {
                    points += 3;
                } else if (enemyMoves[i].equals("A") && myMoves[i].equals("Y")) {
                    points += 1 + 3;
                } else if (enemyMoves[i].equals("A") && myMoves[i].equals("Z")) {
                    points += 2 + 6;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("X")) {
                    points += 1;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("Y")) {
                    points += 2 + 3;
                } else if (enemyMoves[i].equals("B") && myMoves[i].equals("Z")) {
                    points += 3 + 6;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("X")) {
                    points += 2;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("Y")) {
                    points += 3 + 3;
                } else if (enemyMoves[i].equals("C") && myMoves[i].equals("Z")) {
                    points += 1 + 6;
                }
            }

            System.out.println(points);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
