/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Jan 26, 2017
**/

package threadpool;

import java.net.Socket;
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
