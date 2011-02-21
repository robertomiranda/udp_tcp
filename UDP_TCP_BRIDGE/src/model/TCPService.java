/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class TCPService extends Service {

    private ServerSocket serverSocket;

    public TCPService(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    @Override
    public void startService() {
        this.start();
    }

    @Override
    public void stopService() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void run()
    {
            System.out.println("Starting up tcp service, waiting new clients");
            while(true)
            {
                  try{
                        //3. Aceptamos los clientes
                        Socket socket = serverSocket.accept();

                        DataInputStream dis=new DataInputStream(socket.getInputStream());
                        String nickName = dis.readUTF();
                        Client c = new Client(nickName,socket,CLIENTS);                        
                        CLIENTS.add(c);

                        System.out.println(CLIENTS.size());
                  }catch (IOException ex) {
                        Logger.getLogger(TCPService.class.getName()).log(Level.SEVERE, null, ex);
            }     }

    }


}
