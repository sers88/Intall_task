import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static StringBuilder logs = new StringBuilder();
    private static final String DEFAULT_PATH = "E:\\Games";
    public static void main(String[] args) {
        createDirectory(DEFAULT_PATH + "\\src");
        createDirectory(DEFAULT_PATH + "\\res");
        createDirectory(DEFAULT_PATH + "\\savegames");
        createDirectory(DEFAULT_PATH + "\\temp");
        createDirectory(DEFAULT_PATH + "\\src\\main");
        createDirectory(DEFAULT_PATH + "\\src\\test");
        createFile(DEFAULT_PATH + "\\src\\main\\Main.java");
        createFile(DEFAULT_PATH + "\\src\\main\\Utils.java");
        createDirectory(DEFAULT_PATH + "\\res\\drawables");
        createDirectory(DEFAULT_PATH + "\\res\\vectors");
        createDirectory(DEFAULT_PATH + "\\res\\icons");
        createFile(DEFAULT_PATH + "\\temp\\temp.txt");
        fileWriter(DEFAULT_PATH + "\\temp\\temp.txt", logs.toString());
    }

    private static void createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (file.mkdir()) {
                logs.append("Directory is created in ").append(path).append("\n");
            } else {
                logs.append("Failed to create directory in ").append(path).append("\n");
            }
        }
    }

    private static void createFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    logs.append("File is created in ").append(path).append("\n");
                } else {
                    logs.append("Failed to create file in ").append(path).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void fileWriter(String path, String text) {
        File file = new File(path);
        if (file.exists()) {
            try (FileWriter writer = new FileWriter(file, false)) {
                writer.write(text);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}