import java.io.*;
import java.net.*;
 
public class Client {
	public static void main(String[] args) {
    	Socket socket = null;
        BufferedReader userInput = null;
        BufferedReader input = null;
        PrintWriter output = null;
 
    	try {
            socket = new Socket("localhost", 5005);
            System.out.println("Connected to server. Type messages or 'exit' to quit.");
 
            userInput = new BufferedReader(new InputStreamReader(System.in));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
 
            String message;
            while (true) {
                System.out.print("You: ");
                message = userInput.readLine();
                output.println(message);
 
                if ("exit".equalsIgnoreCase(message)) {
                    break;
                }
                System.out.println("Server: " + input.readLine());
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	} finally {
        	try {
                if (userInput != null) userInput.close();
                if (input != null) input.close();
                if (output != null) output.close();
                if (socket != null) socket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
}
