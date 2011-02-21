/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package observador;

/**
 *
 * @author enino
 */
public interface Observable {
    public void addObservers(Observer o);
    public void notifyObservers(Object msj);
}







