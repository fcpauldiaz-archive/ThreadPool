/**
* Universidad Del Valle de Guatemala
* Pablo Diaz 13203
* Jan 26, 2017
**/

package threadpool;

/**
 *
 * @author SDX
 */
public class RequestExecutor implements Runnable {
    
    private WorkingQueue cola;
    public RequestExecutor(WorkingQueue queue) {
        this.cola = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String name = Thread.currentThread().getName();
                Runnable request = cola.get();
                System.out.println("Request empieza por : " + name);
                request.run();
                System.out.println("Request termina por : " + name);
            }
        } catch (InterruptedException e) {

        }
    }

}
