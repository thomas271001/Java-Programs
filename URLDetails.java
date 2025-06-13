import java.net.*;

public class URLDetails {
    public static void main(String[] args) {
        try {
            String urlString = "https://www.google.com/search?q=java+programming";

            // Create URI first, then convert to URL (avoids deprecated URL(String) constructor)
            URI uri = new URI(urlString);
            URL url = uri.toURL();

            System.out.println("Protocol: " + uri.getScheme());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + (uri.getPort() == -1 ? "Default Port" : uri.getPort()));
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery()); // Shows query parameters
        } catch (URISyntaxException | MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}
