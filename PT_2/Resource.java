import java.util.LinkedList;
import java.util.Queue;

public class Resource {
    private Queue<Integer> queue=new LinkedList<>();

    public synchronized Integer take() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();//Wait, maybe someone will put sth here.
        }

        return queue.poll();
    }

    public synchronized void put(Integer value) {
        queue.offer(value);
        notifyAll();
    }
}