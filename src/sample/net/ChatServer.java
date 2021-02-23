package sample.net;

import javafx.scene.input.InputEvent;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import java.awt.event.InputEvent;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer extends Thread {

    public final static int PORT = 5000;
    private final static int BUFFER = 1024;
    int MAX_Y =1 ;
    int MAX_X =1 ;
    private DatagramSocket socket;
    private ArrayList<InetAddress> clientAddresses;
    private ArrayList<Integer> clientPorts;
    private HashSet<String> existingClients;
    public ChatServer() throws IOException {
        socket = new DatagramSocket(PORT);
        clientAddresses = new ArrayList();
        clientPorts = new ArrayList();
        existingClients = new HashSet();
    }
    
    public void run() {

        byte[] buf = new byte[BUFFER];
        while (true) {
            try {
                Arrays.fill(buf, (byte)0);
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String content = new String(buf, buf.length);
                JSONParser jsonParser = new JSONParser();
                Object obj = jsonParser.parse(content.trim());
                JSONObject employeeList = (JSONObject) obj;


                    String x= (String) employeeList.get("X");
                    String y= (String) employeeList.get("Y");
                    float MAX_x = Float.parseFloat(x) ;
                    float MAX_y=Float.parseFloat(y) ;

                    MAX_X= MouseInfo.getPointerInfo().getLocation().x+(int) MAX_x/11;
                    MAX_Y= MouseInfo.getPointerInfo().getLocation().y+(int)MAX_y/11;

                    Robot robot = new Robot();
                    robot.mouseMove(MAX_X,MAX_Y);



                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
            //    System.out.println("\u001B[34m"+" Send Message -> : " +"\u001B[0m"+ content);
//                byte[] data = ("\u001B[34m"+ " : Send you -> " +"\u001B[0m"+  content).getBytes();
//                for (int i=0; i < clientAddresses.size(); i++) {
//                    InetAddress cl = clientAddresses.get(i);
//                    int cp = clientPorts.get(i);
//                    packet = new DatagramPacket(data, data.length, cl, cp);
//                    socket.send(packet);
//                }
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
        ChatServer s = new ChatServer();
        s.start();
    }
}
//  if (MAX_x<=0){
//          MAX_X+=8;
//          }else{
//          MAX_X-=8;
//          }
//          if (MAX_y<=0){
//          MAX_Y+=8;
//          }else {
//          MAX_Y-=8;
//          }