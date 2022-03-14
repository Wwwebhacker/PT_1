

public class Worker implements Runnable {
    private Resource resource;
    private Answers answers;



    public Worker(Resource resource,Answers answers) {
        this.resource = resource;
        this.answers=answers;
    }
    private boolean isPrime(int value) throws InterruptedException {
        Thread.sleep(5000);
        if (value <= 1){

            return false;
        }

        for (int i = 2; i <= Math.sqrt(value); i++){
            if (value % i == 0){
                return false;
            }
        }
        return true;
    }
    @Override
    public void run() {
        while (!Thread.interrupted()){
            try {

                int value=resource.take();

                answers.put(new Result(value,isPrime(value)));
            }catch (InterruptedException ex){
                System.out.println("worker went home");
                break;
            }

        }


    }
}