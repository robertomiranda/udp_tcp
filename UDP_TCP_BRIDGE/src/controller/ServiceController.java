/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.IOException;
import model.TCPService;
import model.UDPService;

/**
 *
 * @author roberto
 */
public class ServiceController {

    private static  ServiceController instance;
    private  model.TCPService tcps;
    private  model.UDPService udps;

    private ServiceController() {
    }

    
    public void startServices(int port) throws IOException{
        tcps = new TCPService(port);
        udps = new UDPService(port);
    }

    public void startServices(int tcpPort, int udpPort) throws IOException{
        tcps = new TCPService(tcpPort);
        udps = new UDPService(udpPort);
        tcps.startService();
        udps.startService();
    }

    public void stopServices(){
    }

    public static ServiceController getInstance(){
        if(instance == null){
            instance = new ServiceController();
        }

        return instance;
    }



}
