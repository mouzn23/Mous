package sample.net;

import java.io.*;
import java.net.*;
import java.util.*;


class MessageSender implements Runnable {

    private void sendMessage(String s) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        byte buf[] = s.getBytes();
        InetAddress address = InetAddress.getByName("192.168.10.50");
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 5000);
        socket.send(packet);
    }
    public void run() {
        boolean connected = false;
        do {
            try {
                sendMessage("GREETINGS ");
                connected = true;
            } catch (Exception e) {
            }
        } while (!connected);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                while (!in.ready()) {
                    Thread.sleep(100);
                }
                String o=in.readLine();
                sendMessage("fgt");
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}

public class ChatClient {
    public static Scanner input =new Scanner(System.in);
    public static void main(String args[]) throws Exception {
        String host = "192.168.10.50";
        int Port=5000;
        DatagramSocket socket = new DatagramSocket();
        MessageSender s = new MessageSender();
        Thread st = new Thread(s);
        st.start();
    }
}
