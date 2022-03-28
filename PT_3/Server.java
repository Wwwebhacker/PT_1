import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static void main(String[] args) {
        LinkedList<Thread> clients=new LinkedList<>();
        try (ServerSocket server = new ServerSocket(9797)) {
            //server.setSoTimeout(10000);
            while (true){

                Socket socket = server.accept();
                System.out.println("New client connected: "+socket);


                clients.add(new Thread(new SocketConnectionHandler(socket)));
                clients.peekLast().start();

                //Thread.sleep(10);


            }

        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
