import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        // INPUT
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        try {
            // SPLIT COMMAND AND DIRECTORY
            String[] inputs = input.split(" ");
            String command = inputs[0];
            Path folder = Paths.get(inputs[1]);

            // EXECUTE COMMANDS
            try {
                switch (command) {
                    case "ls":
                        listFiles(folder);
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void listFiles(Path folder) throws IOException {
        DirectoryStream <Path> stream = Files.newDirectoryStream(folder);
        for (Path path : stream) {
            System.out.println(path.getFileName());
        }
    }
}