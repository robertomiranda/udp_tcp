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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class UDPService extends Service {

    private DatagramSocket datagramSocket;
    

    public UDPService(int port) throws SocketException {
        
        datagramSocket = new DatagramSocket(port);
        
    }

    @Override
    public void run() {

        System.out.println("Starting UDP Service");

        while (true) {
            try {
                byte[] info = new byte[1024];
                DatagramPacket receiver = new DatagramPacket(info, info.length);
                try {
                    datagramSocket.receive(receiver);
                } catch (IOException ex) {
                    Logger.getLogger(UDPService.class.getName()).log(Level.SEVERE, null, ex);
                }
                info = receiver.getData();
                InetAddress ip = receiver.getAddress();
                String message = new String(info);
                int puerto = receiver.getPort();
                System.out.println(ip + ":" + puerto + " dice: " + message);
                notifyClients(message);
            } catch (IOException ex) {
                Logger.getLogger(UDPService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void startService() {
        this.start();
    }

    @Override
    public void stopService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyClients(String message) throws IOException{
        for(Object object: CLIENTS){
            Client client = (Client) object;
            try{
                client.sendMessage(message);
            }catch(java.net.SocketException ex){
                CLIENTS.remove(client);
            }
           
        }
    }

}
