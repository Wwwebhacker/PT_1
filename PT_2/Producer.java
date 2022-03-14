import java.util.Random;

public class Producer implements Runnable {
    private Resource resource;
    public Producer(Resource resource) {
        this.resource = resource;
    }
    @Override
    public void run() {
        int i=5;
        while (i>0){
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int max=999999;
            int min=0;
            resource.put((int) ((Math.random() * (max - min)) + min));
            i--;
        }

    }
}
