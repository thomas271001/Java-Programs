import java.io.*;
import java.net.*;
public class Server {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
    	Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
    	try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server is waiting for a client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
 
input= new BufferedReader(new InputStreamReader(socket.getInputStream()));
  output = new PrintWriter(socket.getOutputStream(), true);
 
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client: " + message);
                output.println("Server received: " + message);
 
                if ("exit".equalsIgnoreCase(message)) {
                    System.out.println("Client disconnected.");
                    break;
                }
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	} finally {
        	try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
