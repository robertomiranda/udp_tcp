/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp_tcp_bridge;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tcpPort=8989;
        int udpPort=9090;
        try {
            controller.ServiceController.getInstance().startServices(tcpPort, udpPort);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
