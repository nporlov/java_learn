import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesAdapter {
    static DirectoryStream<Path> getFileList(Path folder) throws IOException {
        return Files.newDirectoryStream(folder);
    }

    static void createFolder(Path folder) throws IOException {
        Files.createDirectory(folder);
    }

    static void deleteFolder(Path folder) throws IOException {
        Files.delete(folder);
    }

    static void printFileList(DirectoryStream<Path> stream) throws IOException {
        for (Path path : stream) {
            System.out.println(path);
        }
    }
}
