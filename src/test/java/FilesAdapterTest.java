import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FilesAdapterTest {

    @TempDir
    Path tempDir;

    @Test
    void testGetFileList() throws IOException {
        // Подготовка: создаём два файла во временной папке
        Path file1 = tempDir.resolve("file1.txt");
        Path file2 = tempDir.resolve("file2.txt");
        Files.createFile(file1);
        Files.createFile(file2);

        // Выполнение
        try (DirectoryStream<Path> stream = FilesAdapter.getFileList(tempDir)) {
            // Проверка
            assertNotNull(stream);
            int count = 0;
            for (Path path : stream) {
                count++;
                assertTrue(path.getFileName().toString().startsWith("file"));
            }
            assertEquals(2, count);
        }
    }

    @Test
    void testCreateFolder() throws IOException {
        Path newFolder = tempDir.resolve("newFolder");
        FilesAdapter.createFolder(newFolder);

        assertTrue(Files.exists(newFolder));
        assertTrue(Files.isDirectory(newFolder));
    }

    @Test
    void testCreateFolderWhenExists() throws IOException {
        Path existing = tempDir.resolve("existing");
        Files.createDirectory(existing);

        assertThrows(IOException.class, () -> FilesAdapter.createFolder(existing));
    }

    @Test
    void testDeleteFolder() throws IOException {
        Path toDelete = tempDir.resolve("toDelete");
        Files.createDirectory(toDelete);

        FilesAdapter.deleteFolder(toDelete);

        assertFalse(Files.exists(toDelete));
    }

    @Test
    void testDeleteFolderNotExists() {
        Path notExists = tempDir.resolve("notExists");
        assertThrows(IOException.class, () -> FilesAdapter.deleteFolder(notExists));
    }

    @Test
    void testPrintFileList() throws IOException {
        // Подготовка: создаём файл и получаем поток
        Path file = tempDir.resolve("test.txt");
        Files.createFile(file);
        try (DirectoryStream<Path> stream = FilesAdapter.getFileList(tempDir)) {
            // Проверяем, что метод не выбрасывает исключение
            assertDoesNotThrow(() -> FilesAdapter.printFileList(stream));
        }
    }
}