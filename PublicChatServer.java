import java.io.*;
import java.net.*;
import java.util.*;
 
public class PublicChatServer {
	private static Set<PrintWriter> clientWriters = new HashSet<>();
 
	public static void main(String[] args) {
        ServerSocket serverSocket = null;
    	Socket socket = null;
 
    	try {
            serverSocket = new ServerSocket(5005);
            System.out.println("Chat Server started...");
            while (true) {
                socket = serverSocket.accept();
                System.out.println("New client connected.");
                new ClientHandler(socket).start();
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	} finally {
        	try {
                if (serverSocket != null) serverSocket.close();
        	} catch (IOException e) {
                e.printStackTrace();
        	}
    	}
	}
 
	static class ClientHandler extends Thread {
    	private Socket socket;
    	private PrintWriter output;
    	private BufferedReader input;
    	public ClientHandler(Socket socket) {
            this.socket = socket;
    	}
    	public void run() {
        	try {
input= new BufferedReader(new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                synchronized (clientWriters) {
                    clientWriters.add(output);
                }
                String message;
                while ((message = input.readLine()) != null) {
                    System.out.println("Received: " + message);
                    broadcastMessage(message);
                }
        	} catch (IOException e) {
                e.printStackTrace();
        	} finally {
                try {
                    if (input != null) input.close();
                    if (output != null) {
                        synchronized (clientWriters) {
                            clientWriters.remove(output);
                        }
                        output.close();
                    }
                    if (socket != null) socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        	}
    	}
    	private void broadcastMessage(String message) {
            synchronized (clientWriters) {
                for (PrintWriter writer : clientWriters) {
                    writer.println(message);
                }
        	}
    	}
	}
}
