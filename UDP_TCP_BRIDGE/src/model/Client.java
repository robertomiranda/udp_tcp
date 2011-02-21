/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class Client {

    String nickname;
    Socket socket;
    ArrayList<Client> clients;
    //Lo que me envia el cliente lo recibo por entrada
    private DataInputStream dataInputStream;
    //Lo que le envio al cliente lo envio por salida
    private DataOutputStream dataOutputStream;

    public Client(String nickname, Socket socket, ArrayList<Client> clients) throws IOException {
        this.nickname = nickname;
        this.socket = socket;
        this.clients = clients;
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void sendMessage(String message) throws IOException {
        dataOutputStream.writeUTF(message);
        dataOutputStream.flush();
    }

    public void update(String msj) {
        try {
            sendMessage(msj);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
