/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author roberto
 */
public class ServiceController {

    public static  ServiceController instance;
    private  model.TCPService tcps;
    private  model.UDPService udps;

    public ServiceController() {
    }

    
    public void startServices(){
    }

    public void stopServices(){
    }

    public ServiceController getInstance(){
        if(instance == null){
            instance = new ServiceController();
        }

        return instance;
    }



}
