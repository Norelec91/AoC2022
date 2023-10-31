import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoC5 {

    static class Movement {
        int cratesN;
        int fromStack;
        int toStack;

        public Movement(int cratesN, int fromStack, int toStack) {
            this.cratesN = cratesN;
            this.fromStack = fromStack;
            this.toStack = toStack;
        }

        @Override
        public String toString() {
            return cratesN + " - " + fromStack + " - " + toStack;
        }
    }

    public static void main(String[] args) {
        String fileName = "AoC5";

        try {
            var file = Arrays.stream(Files.readString(Paths.get(fileName))
                    .split("\n"))
                    .toList();

            // parser

            List<Deque<String>> stacks = new ArrayList<>();
            List<Movement> movements = new ArrayList<>();

            boolean isMovements = false;

            for (String s : file) {
                if (!isMovements) {
                    if (!s.isEmpty()) {
                        String crates = s.replace("   ","[x]").replace(" ", "").replace("[","").replace("]","");

                        if (!Character.isDigit(crates.charAt(0))) {
                            for (int i = 0; i < crates.length(); i++) {
                                if (stacks.size() <= i) {
                                    stacks.add(new ArrayDeque<>());
                                }

                                if (crates.charAt(i) != 'x') {
                                    stacks.get(i).addLast(String.valueOf(crates.charAt(i)));
                                }
                            }
                        }
                    } else {
                        isMovements = true;
                    }
                } else {
                    String[] m = s.replace("move ", "").replace(" from ", ",").replace(" to ", ",").split(",");

                    Movement movement = new Movement(
                            Integer.parseInt(m[0]),
                            Integer.parseInt(m[1]),
                            Integer.parseInt(m[2])
                    );

                    movements.add(movement);
                }
            }

            for (Movement movement : movements) {
                System.out.println(movement);

                for (int i = 0; i < movement.cratesN; i++) {
                    stacks.get(movement.toStack - 1).push(stacks.get(movement.fromStack - 1).pop());
                }

                System.out.println(stacks);
            }

            String endResult = "";

            for (Deque<String> stack : stacks) {
                endResult += stack.getFirst();
            }

            System.out.println(endResult);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}