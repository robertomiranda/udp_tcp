/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author roberto
 */
public class UDPClient {

    private DatagramSocket datagramSocket;
    private static UDPClient udpc;
    private InetAddress ip;
    private int port;
    
    private UDPClient(int port,  String ip) throws SocketException, UnknownHostException {
        this.ip = InetAddress.getByName(ip);
        this.port = port;
        datagramSocket = new DatagramSocket();
    }

    public void sendMessage(String message) throws IOException{
       byte[] info = message.getBytes();
       DatagramPacket sender = new DatagramPacket(info, info.length);
       sender.setAddress(ip);
       sender.setPort(port);
       System.out.println("Sending message: " + message);
       datagramSocket.send(sender);
    }

    public static UDPClient getInstance(int port, String ip) throws SocketException, UnknownHostException{
        if(udpc == null)
            udpc = new UDPClient(port, ip);
        return  udpc;
    }

}
