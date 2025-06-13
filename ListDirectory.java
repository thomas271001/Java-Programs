import java.io.File;

public class ListDirectory {
    public static void main(String[] args) {
        // Use the home directory of the current user
        String path = System.getProperty("user.home"); // macOS/Linux compatible
        File directory = new File(path);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        System.out.println("[DIR]  " + file.getName());
                    } else if (file.isFile()) {
                        System.out.println("[FILE] " + file.getName());
                    }
                }
            } else {
                System.out.println("Error: Could not list files.");
            }
        } else {
            System.out.println("Invalid directory path!");
        }
    }
}
