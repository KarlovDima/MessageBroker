import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
        String rootFolderPath = args[0];
        int generatedFoldersAmount = Integer.parseInt(args[1]);
        int generatedFilesAmount = Integer.parseInt(args[2]);

        for (int i = 0; i < generatedFoldersAmount; i++) {
            File file = createDirectory(rootFolderPath);
            createFiles(file.getPath(), generatedFilesAmount);
        }
    }

    private static File createDirectory(String rootFolderPath) {
        File file;
        do {
            file = new File(rootFolderPath + "/" + getDirectoryName());
        } while (!file.mkdirs());

        return file;
    }

    private static String getDirectoryName() {
        return "c" + getDirectoryNumbers();
    }

    private static int getDirectoryNumbers() {
        return ThreadLocalRandom.current().nextInt(1000, 10000);
    }

    private static void createFiles(String path, int generatedFilesAmount) throws IOException {
        for (int i = 0; i < generatedFilesAmount; i++) {
            createFile(path);
        }
    }

    private static void createFile(String path) throws IOException {
        File file;
        do {
            file = new File(path + "/" + getFileNumbers() + ".txt");
        } while (file.exists());

        file.createNewFile();
        writeContent(path + "/" + file.getName());
    }

    private static long getFileNumbers() {
        return ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
    }

    private static void writeContent(String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write("Content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
