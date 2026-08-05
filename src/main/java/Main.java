import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Path myFolder = Paths.get("C:\\Dev\\java\\workspace");
        try {
            DirectoryStream <Path> stream = Files.newDirectoryStream(myFolder);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            System.out.println(input);
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}