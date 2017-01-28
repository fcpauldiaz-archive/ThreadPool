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
public class Pool {

    WorkingQueue queue;
    
    public Pool(int nThread) {
        this.queue = new WorkingQueue(nThread);
        
        for (int count = 0; count < nThread; count++) {
            String threadName = "Thread - " + count;
            RequestExecutor request = new RequestExecutor(queue);
            Thread thread = new Thread(request, threadName);
            thread.start();
        }
    }

    public void addRequest(HttpRequest rq) throws InterruptedException  {
        queue.put(rq);
    }
}
