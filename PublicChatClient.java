import java.io.*;
import java.net.*;
public class PublicChatClient {
	public static void main(String[] args) {
    	try {
            Socket socket = new Socket("localhost", 5005);
            System.out.println("Connected to chat server.");
 
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

Thread messageReceiver = new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = input.readLine()) != null) { 
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        	});
            messageReceiver.start();
            String message;
            while ((message = userInput.readLine()) != null) {
                output.println(message);
        	}
            socket.close();
    	} catch (IOException e) {
            e.printStackTrace();
    	}
	}
}
