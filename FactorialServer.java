import java.io.*;
import java.net.*;
public class FactorialServer {
	public static void main(String[] args) {
    	try (ServerSocket serverSocket = new ServerSocket(5005)) {
            System.out.println("Server is running... Waiting for a client...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
 BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
                int number = Integer.parseInt(input.readLine());
                long factorial = calculateFactorial(number);
                output.println("Factorial of " + number + " is: " + factorial);
                clientSocket.close();
        	}
    	} catch (IOException e) {
            e.printStackTrace();
    	}
	}
	private static long calculateFactorial(int num) {
    	long fact = 1;
    	for (int i = 2; i <= num; i++) {
        	fact *= i;
    	}
    	return fact;
	}
}
