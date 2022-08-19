

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

/**
 * An example of client-side application using UDP
 * @author emalianakasmuri
 *
 */

public class UDPClientSideApp {

	public static void main(String[] args) {
		
		System.out.println("\n\tUDPClientSideApp: Demonstration of UDP "
				+ "Client-Side Application.");
		
		
		
		try {
			
			// 1. Define server port number and address
			int portNo = 8083;
			InetAddress ip = InetAddress.getLocalHost();
			
			// 2. Prepare and transform data into bytes
			String text = "Good morning Malaysia Singapore Vietnam";
			byte buf[] = text.getBytes();

			// 3. Wrap data in datagram packet (constructor no 5)
			DatagramPacket outPacket = 
					new DatagramPacket(buf, buf.length, ip, portNo);
			
			// 4. Create the socket object to transmit the data.
			DatagramSocket datagramSocket = new DatagramSocket();

			// 5. Send datagram packet
			datagramSocket.send(outPacket);
			System.out.println("\n\tSending '" + text + "' (" + text.length() 
				+ ") out on network.");
			
			// 6.New buffer to extract the received data
			byte[] inData = new byte[65535];
			byte[] vowelData = new byte[65535];
			byte[] consonantData = new byte[65535];
			byte[] punctuationData = new byte[65535];
			
			// 7. Packet to receive data
			DatagramPacket inPacket = new DatagramPacket(inData, inData.length);
			DatagramPacket vowelPacket = new DatagramPacket(vowelData, vowelData.length);
			DatagramPacket consonantPacket = new DatagramPacket(consonantData, consonantData.length);
			DatagramPacket punctuationPacket = new DatagramPacket(punctuationData, punctuationData.length);
			
			// 8. Receive data
			datagramSocket.receive(inPacket);
			datagramSocket.receive(vowelPacket);
			datagramSocket.receive(consonantPacket);
			datagramSocket.receive(punctuationPacket);
			
			// 9. Extract data
			inData = inPacket.getData();
			vowelData = vowelPacket.getData();
			consonantData = consonantPacket.getData();
			punctuationData = punctuationPacket.getData();
			
			// 10. Further processing
			// Transform data into human readable text
			String length = new String(inData, 0, inPacket.getLength());
			String vowels = new String(vowelData, 0, vowelPacket.getLength());
			String consonants = new String(consonantData, 0, consonantPacket.getLength());
			String punctuations = new String(punctuationData, 0, punctuationPacket.getLength());
			
			// Display the data received from the server
			System.out.println("\tLength from the server is : " + length);
			System.out.println("\tNumber of vowels from the server is : " + vowels);
			System.out.println("\tNumber of consonants from the server is : " + consonants);
			System.out.println("\tNumber of punctuations from the server is : " + punctuations);
			
			
			datagramSocket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("\n\tUDPClientSideApp: End of program.");

	}

}
