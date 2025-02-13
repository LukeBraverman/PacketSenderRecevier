package packetapp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class PacketSender {

    public static void main(String[] args) throws IOException {

        String message = "NO 4!";
         String targetIP = "localhost"; // Replace with your local IP
        //String targetIP = "52.56.143.87"; // Replace with your local IP

        int port = 9876; // The port your PacketInspector program is listening on

        // Convert the message to bytes
        byte[] buffer = message.getBytes();

        // Create the socket and target address
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(targetIP);

        // Create and send the packet
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);

        System.out.println("Message sent: " + message);

        // Close the socket
        socket.close();
    }
}
