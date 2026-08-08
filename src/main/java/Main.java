import java.io.IOException;
import java.nio.file.*;

public class Main {
    static void main(String[] args) {
        String command = null;
        Path folder = null;
        try {
            command = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No command entered. " + e);
        }

        try {
            folder = Paths.get(args[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("No argument entered. " + e);
        } catch (InvalidPathException e) {
            System.out.println("Invalid path entered. " + e);
        }

        try {
            switch (command) {
                case "ls": FilesAdapter.getFileList(folder);
            }
        } catch (IOException e) {
            System.out.println("Error opening files list. " + e);
        } catch (NullPointerException e) {
            System.out.println("No files list found. " + e);
        }
    }
}