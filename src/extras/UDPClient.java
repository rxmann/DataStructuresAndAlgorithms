package extras;
import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("UDP Client.");

        DatagramSocket socket = new DatagramSocket(2002);
        System.out.println("Listening on port 2002");

        String message = "Hello World, 2025.";
        DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 2003);
        System.out.println("Sending UDP packet: " + message);
        Thread.sleep(5000);
        socket.send(packet);
        Thread.sleep(5000);
        System.out.println("Sent UDP packet: " + message);

        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        System.out.println("Waiting UDP packet: " + new String(packet.getData(), 0, packet.getLength()));
        Thread.sleep(5000);
        socket.receive(packet);
        Thread.sleep(5000);
        System.out.println("Received UDP packet: " + new String(packet.getData(), 0, packet.getLength()));

        message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("From server: " + message);

        socket.close();
    }
}


