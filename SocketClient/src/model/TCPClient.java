/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import observador.Observer;

/**
 *
 * @author roberto
 */
public class TCPClient extends Thread implements observador.Observable {

    private SocketConnection sc;
    private DataInputStream reciever;
    private Observer observer;
    private  static TCPClient instance;
    private TCPClient(String port, String ip) throws IOException {
       sc = (SocketConnection)Connector.open("socket://"+ip+":"+port, Connector.READ_WRITE);
        reciever = sc.openDataInputStream();
        this.start();
    }

    public static TCPClient getInstance(String port, String ip) throws IOException{
        if(instance == null)
            instance = new TCPClient(port, ip);
        return instance;
    }


    public void run() {
        while (true) {
            try {
                String msj = reciever.readUTF();
                System.out.println("----------------------");
                System.out.println(msj);
                notifyObservers(msj);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addObservers(Observer o) {
        observer = o;
    }

    public void notifyObservers(Object msj) {
        observer.update(msj);
    }




}
