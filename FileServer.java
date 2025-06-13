import java.io.*;
import java.net.*;
 
public class FileServer {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
    	Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
        FileInputStream fileInput = null;
        BufferedOutputStream fileOutput = null;
 
    	try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server started. Waiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
 
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
 
            String fileName = input.readLine();
        	File file = new File(fileName);
 
        	if (file.exists() && file.isFile()) {
                output.println("FOUND");
                fileInput = new FileInputStream(file);
                fileOutput = new BufferedOutputStream(socket.getOutputStream());
 
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileInput.read(buffer)) != -1) {
                    fileOutput.write(buffer, 0, bytesRead);
                }
                fileOutput.flush();
                System.out.println("File sent successfully.");
        	} else {
                output.println("NOT_FOUND");
                System.out.println("File not found.");
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
                if (serverSocket != null) serverSocket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
