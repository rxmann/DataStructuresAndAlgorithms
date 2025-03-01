package extras;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        System.out.println("UDP Server.");

        DatagramSocket ds = new DatagramSocket(2003);
        System.out.println("Listening on port 2003");

        byte b[] = new byte[1024];
        DatagramPacket dp = new DatagramPacket(b, 1024);
        System.out.println("Waiting for UDP packet: " + new String(b));
        Thread.sleep(5000);
        ds.receive(dp);
        Thread.sleep(5000);
        System.out.println("Received UDP packet: " + new String(b));


        String msg = new String(dp.getData(), 0, dp.getLength());
        System.out.println("From Client: " + msg);
        StringBuilder sb = new StringBuilder(msg);
        sb.reverse();
        msg = sb.toString();

        System.out.println("Sending UDP packet: " + msg);
        dp = new DatagramPacket(msg.getBytes(), msg.length(), InetAddress.getByName("localhost"), 2002);
        Thread.sleep(5000);
        ds.send(dp);
        Thread.sleep(5000);
        System.out.println("Sent UDP packet: " + msg);

        ds.close();
    }
}