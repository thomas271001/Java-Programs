import java.io.*;
import java.net.*;
 
public class FileClient {
	public static void main(String[] args) {
    	Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
        BufferedInputStream fileInput = null;
        FileOutputStream fileOutput = null;
 
    	try {
            socket = new Socket("localhost", 5005);
            System.out.println("Connected to server.");
 
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
 
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter file name to download: ");
            String fileName = userInput.readLine();
            output.println(fileName);
 
            String response = input.readLine();
        	if ("FOUND".equals(response)) {
                fileInput = new BufferedInputStream(socket.getInputStream());
                fileOutput = new FileOutputStream("Downloaded_" + fileName);
 
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileInput.read(buffer)) != -1) {
                    fileOutput.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded successfully.");
        	} else {
                System.out.println("File not found on server.");
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	} finally {
        	try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (fileInput != null) fileInput.close();
                if (fileOutput != null) fileOutput.close();
                if (socket != null) socket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
