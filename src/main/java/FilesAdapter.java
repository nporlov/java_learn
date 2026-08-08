import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FilesAdapter {
    static void getFileList(Path folder) throws IOException {
        DirectoryStream<Path> stream = Files.newDirectoryStream(folder);
        for (Path path : stream) {
            System.out.println(path.getFileName());
        }
    }

    static void createFolder(Path folder) throws IOException {
        Files.createDirectory(folder);
        System.out.println("Folder created");
    }

    static void deleteFolder(Path folder) throws IOException {
        Files.delete(folder);
        System.out.println("Folder deleted");
    }
}
