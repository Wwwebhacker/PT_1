import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) {

        try (Socket client = new Socket("localhost", 9797)) {

            //ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
//            Message msg=new Message();
//            msg.setContent("asdad");
//            msg.setNumber(123);
//            out.writeObject(msg);

            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());

            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            System.out.println("connected to server: "+client);

            //BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            while (true){
                String ans=(String) in.readObject();
                System.out.println("Server: "+ans);
                if ((ans!=null)&&(ans.equals("ready"))){



                    Scanner scanner=new Scanner(System.in);

                    Integer n=Integer.parseInt(scanner.nextLine());
                    out.writeObject(n);

                    ans=(String) in.readObject();
                    System.out.println("Server: "+ans);

                    if (ans.equals("ready for messages")){
                        for (int i = 0; i < n; i++) {
                            Message msg=new Message();
                            msg.setNumber(i);
                            msg.setContent(scanner.nextLine());
                            out.writeObject(msg);
                        }
                    }
                    ans=(String) in.readObject();
                    System.out.println("Server: "+ans);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            System.err.println(ex);
        }

    }
}
