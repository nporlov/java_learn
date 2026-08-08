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
}
