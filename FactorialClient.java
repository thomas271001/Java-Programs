import java.io.*;
import java.net.*;
public class FactorialClient {
	public static void main(String[] args) {
    	try (Socket socket = new Socket("localhost", 5005)) {
BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
   PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
 
            System.out.print("Enter a number: ");
        	int number = Integer.parseInt(userInput.readLine());
            output.println(number);
            System.out.println(input.readLine());
    	} catch (IOException e) {
            e.printStackTrace();
    	}
	}
}
