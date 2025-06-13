import java.net.*;
 public class UDPServer {
	public static void main(String[] args) {
    	try (DatagramSocket serverSocket = new DatagramSocket(5005)) {
            byte[] receiveBuffer = new byte[1024];
            System.out.println("Server is running... Waiting for messages...");
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);
 
                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + receivedMessage);
                String responseMessage = "Echo: " + receivedMessage;
                byte[] responseData = responseMessage.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData, responseData.length, receivePacket.getAddress(), receivePacket.getPort());
                serverSocket.send(responsePacket);
        	}
    	} catch (Exception e) {
            e.printStackTrace();
    	}
	}
}
