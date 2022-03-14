import java.util.ArrayList;
import java.util.Scanner;

public class PT_2 {
    public static void main(String[] args) throws InterruptedException {
        Resource r=new Resource();

        Producer p=new Producer(r);

        Answers answers=new Answers();

        Worker w=new Worker(r,answers);

        Thread pt=new Thread(p);
        pt.start();

        int workersNumber=5;
        ArrayList<Thread> wthreads=new ArrayList<>(workersNumber);
        for (int i = 0; i < workersNumber; i++) {
            Thread wt=new Thread(w);
            wt.start();
            wthreads.add(wt);
        }



        String cmd=" ";
        Scanner scan = new Scanner(System.in);
        while (!cmd.equals("x")){
            cmd=scan.nextLine();
            if (cmd.equals("p")){
                System.out.println(answers.getAnswers());
                continue;
            }
            int intValue;
            try {
                intValue = Integer.parseInt(cmd);

            } catch (NumberFormatException e) {
                continue;
            }
            r.put(intValue);
        }

        for (Thread wt:wthreads){
            wt.interrupt();
        }
        for (Thread wt:wthreads){
            wt.join();
        }

        pt.join();
        System.out.println(answers.getAnswers());



    }
}
