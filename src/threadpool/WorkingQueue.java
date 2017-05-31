/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Jan 26, 2017
**/

package threadpool;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Cola Sincronizada
 * @author SDX
 */
public class WorkingQueue {
    
    private Queue cola;
    private int maxSize;
    
    public WorkingQueue(int maxSize) {
        this.cola = new LinkedList();
        this.maxSize = maxSize;
    }
    
    public synchronized HttpRequest get() throws InterruptedException {
        while(this.cola.size() == 0) {
            //creo que aqui iria el modo pánico
            //pero no puedo instanciar threads aqui ¿?
            wait();
        }
        if(this.cola.size() == maxSize) {
            notifyAll();
        }
        return (HttpRequest)this.cola.poll();
    }
    
    public synchronized void put(HttpRequest e) throws InterruptedException {
        while(this.cola.size() == maxSize) {
            wait();
        }
        if (this.cola.isEmpty()) {
            notifyAll();
        }
        this.cola.add(e);
    }
    

}
