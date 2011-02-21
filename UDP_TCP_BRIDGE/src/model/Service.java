/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author roberto
 */
public abstract class Service extends Thread {

    protected final static ArrayList<Client> CLIENTS = new ArrayList<Client>();

    public Service(){
    }


    public abstract void startService();
    public abstract void stopService();

}
