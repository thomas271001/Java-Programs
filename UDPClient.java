import java.io.*;
import java.net.*;
 
public class UDPClient {
	public static void main(String[] args) {
    	try (DatagramSocket clientSocket = new DatagramSocket()) {
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
 
            InetAddress serverAddress = InetAddress.getByName("localhost");
        	int serverPort = 5005;
 
            System.out.print("Enter message: ");
            String message = userInput.readLine();
            byte[] sendData = message.getBytes();
 DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);
 
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);
 
            String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server Response: " + serverResponse);
 
    	} catch (Exception e) {
            e.printStackTrace();
    	}
	}
}
