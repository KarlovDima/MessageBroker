import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class Creator {
    private Parameters parameters;

    public Creator(Parameters parameters) {
        this.parameters = parameters;
    }

    public void create() throws IOException {
        for (int i = 0; i < parameters.getGeneratedDirectoriesAmount(); i++) {
            File file = createDirectory();
            createFiles(file.getPath());
        }
    }

    private File createDirectory() {
        File file;
        do {
            file = new File(parameters.getRootDirectory() + "/" + getDirectoryName());
        } while (!file.mkdirs());

        return file;
    }

    private String getDirectoryName() {
        return "c" + getDirectoryNumbers();
    }

    private int getDirectoryNumbers() {
        return ThreadLocalRandom.current().nextInt(1000, 10000);
    }

    private void createFiles(String path) throws IOException {
        for (int i = 0; i < parameters.getGeneratedFilesAmount(); i++) {
            createFile(path);
        }
    }

    private void createFile(String path) throws IOException {
        File file;
        do {
            file = new File(path + "/" + getFileNumbers() + ".txt");
        } while (file.exists());

        file.createNewFile();
        writeContent(path + "/" + file.getName());
    }

    private long getFileNumbers() {
        return ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
    }

    private void writeContent(String path) {
        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write("Content");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
