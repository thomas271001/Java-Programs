import java.io.*;
import java.net.*;
 
public class ChatClient {
	public static void main(String[] args) {
    	Socket socket = null;
        BufferedReader input = null;
        PrintWriter output = null;
        BufferedReader userInput = null;
 
    	try {
            socket = new Socket("localhost", 5005);
            System.out.println("Connected to server. Type your messages:");
 
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            userInput = new BufferedReader(new InputStreamReader(System.in));
 
            String message;
            while (true) {
                if (userInput.ready()) {
                    message = userInput.readLine();
                    output.println(message);
                    if ("exit".equalsIgnoreCase(message)) {
                        System.out.println("Chat closed.");
                        break;
                    }
                }
 
                if (input.ready()) {
                    message = input.readLine();
                    if ("exit".equalsIgnoreCase(message)) {
                        System.out.println("Server disconnected.");
                        break;
                    }
                    System.out.println("Server: " + message);
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
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
