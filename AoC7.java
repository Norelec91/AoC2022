import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class AoC7 {

    static class File {
        String name;
        long size;
        List<File> content;
        File parent;
    }

    public static void main(String[] args) {
        String fileName = "AoC7";

        try {
            var lines = Arrays.stream(Files.readString(Paths.get(fileName))
                            .split("\n")).map(s -> s.split(" "))
                    .toList();

            File rootFile = new File();
            rootFile.name = "/";
            rootFile.content = new ArrayList<>();

            File selectedFile = rootFile;

            for (var element : lines) {
                if (element[0].equals("$")) {
                    if (element[1].equals("cd")) {
                        String destinationFolder = element[2];

                        if (destinationFolder.equals("..")) {
                            if (selectedFile.parent != null) {
                                selectedFile = selectedFile.parent;
                            }
                        } else if (!destinationFolder.equals("/")) {
                            for (int i = 0; i < selectedFile.content.size(); i++) { // size dell'array...
                                if (selectedFile.content.get(i).name.equals(destinationFolder)) {
                                    selectedFile = selectedFile.content.get(i);
                                }
                            }
                        }
                    }
                } else {
                    File newFile = new File();
                    newFile.name = element[1];
                    newFile.parent = selectedFile;

                    if (!element[0].equals("dir")) {
                        newFile.size = Long.parseLong(element[0]);

                        File selectedSelectedFile = newFile;

                        while (selectedSelectedFile.parent != null) {
                            selectedSelectedFile = selectedSelectedFile.parent;
                        }
                    } else {
                        newFile.content = new ArrayList<>();
                    }

                    selectedFile.content.add(newFile);
                }
            }

            List<Long> foldersAtMost100000 = new ArrayList<>();
            List<Long> foldersOver100000 = new ArrayList<>();

            countSizeAtMost100000(foldersAtMost100000, foldersOver100000, rootFile);

            System.out.println(foldersAtMost100000.stream().mapToLong(x -> x.longValue()).sum());

            long spaceNeeded = 30000000 - (70000000 - countSize(rootFile));

            System.out.println(foldersOver100000.stream().filter(x -> x >= spaceNeeded).sorted(Long::compare).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static long countSizeAtMost100000(List<Long> foldersAtMost100000, List<Long> foldersOver100000, File file) {
        if (file.content != null) {
            long sum = 0;

            for (File f : file.content) {
                sum += countSizeAtMost100000(foldersAtMost100000, foldersOver100000, f);
            }

            if (sum <= 100000) {
                foldersAtMost100000.add(sum);
            } else {
                foldersOver100000.add(sum);
            }

            return sum;
        } else {
            return file.size;
        }
    }

    static long countSize(File file) {
        if (file.content != null) {
            long sum = 0;

            for (File f : file.content) {
                sum += countSize(f);
            }

            return sum;
        } else {
            return file.size;
        }
    }
}