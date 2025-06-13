import java.io.File;

public class FileSearch {

    public static boolean searchFile(File directory, String filename) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    if (searchFile(file, filename)) {
                        return true;
                    }
                } else if (file.getName().equalsIgnoreCase(filename)) {
                    System.out.println("File Found: " + file.getAbsolutePath());
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Use a macOS-compatible path
        String directoryPath = System.getProperty("user.home") + "/Downloads";
        String fileNameSearch = "AI.pages";

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            if (!searchFile(directory, fileNameSearch)) {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}
