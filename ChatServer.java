import java.io.*;
import java.net.*;
 
public class ChatServer {
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
    	Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
        BufferedReader userInput = null;
 
    	try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Server started. Waiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");
 
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            userInput = new BufferedReader(new InputStreamReader(System.in));
 
            String message;
            while (true) {
                if (input.ready()) {
                    message = input.readLine();
                    if ("exit".equalsIgnoreCase(message)) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                    System.out.println("Client: " + message);
                }
 
                if (userInput.ready()) {
                    message = userInput.readLine();
                    output.println(message);
                    if ("exit".equalsIgnoreCase(message)) {
                        System.out.println("Chat closed.");
                        break;
                    }
                }
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	} finally {
        	try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (userInput != null) userInput.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
