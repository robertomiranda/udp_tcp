/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package udp_sender;

import view.MainWindow;

/**
 *
 * @author roberto
 */
public class Main {

    /**
     * @param args the command line arguments
     */
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

}
