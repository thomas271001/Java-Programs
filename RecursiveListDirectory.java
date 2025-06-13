import java.io.File;

public class RecursiveListDirectory {

    public static void listFiles(String directoryPath, int level) {
        File dir = new File(directoryPath);

        // Validate if directory exists
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Invalid directory path!");
            return;
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                // Proper indentation
                for (int i = 0; i < level; i++) {
                    System.out.print("   "); // Print spaces instead of newlines
                }

                if (file.isDirectory()) {
                    System.out.println("[DIR]  " + file.getName());
                    listFiles(file.getAbsolutePath(), level + 1); // Recursive call for subdirectory
                } else {
                    System.out.println("[FILE] " + file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        // Use a macOS-compatible path
        String path = System.getProperty("user.home") + "/Documents/javaprograms";
        listFiles(path, 0);
    }
}
