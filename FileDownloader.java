import java.io.*;
import java.net.*;
import java.nio.file.*;

public class FileDownloader {
    public static void downloadFile(String fileURL, String savePath) {
        try {
            // Use URI to avoid deprecated URL(String) constructor
            URI uri = new URI(fileURL);
            URL url = uri.toURL();

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestProperty("User-Agent", "Mozilla/5.0"); // Prevents blocking

            if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                try (InputStream in = httpConn.getInputStream()) {
                    Files.copy(in, Paths.get(savePath), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Download complete: " + savePath);
                }
            } else {
                System.out.println("Server returned: " + httpConn.getResponseMessage());
            }
            httpConn.disconnect();
        } catch (URISyntaxException | IOException e) {
            System.out.println("Error downloading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileURL = "https://www.uou.ac.in/sites/default/files/slm/BHM-503T.pdf";
        String savePath = "downloaded_file.pdf";
        downloadFile(fileURL, savePath);
    }
}
