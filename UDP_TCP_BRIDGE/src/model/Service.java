/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;

/**
 *
 * @author roberto
 */
public abstract class Service extends Thread {

    protected final static HashMap CLIENTS = new HashMap();

    public Service(){
    }


    public abstract void startService();
    public abstract void stopService();

}
