import java.io.*;
import java.net.Socket;

public class SocketConnectionHandler implements Runnable{
    private final Socket socket;
    private final int port;
    public SocketConnectionHandler(Socket socket) {
        this.socket = socket;
        this.port=socket.getPort();
    }

    @Override
    public void run() {


        try (ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())) {



            while (!Thread.interrupted()){


                out.writeObject("ready");
                Integer n=(Integer)in.readObject();
                System.out.println("Client ["+port+ "]: "+n);

                out.writeObject("ready for messages");
                for (int i = 0; i < n; i++) {
                    Message msg=(Message) in.readObject();
                    System.out.println("Client ["+port+ "]: "+msg.getContent());
                }

                out.writeObject("finished");

            }
        } catch (IOException | ClassNotFoundException ex) {
            System.out.print("SocketConnectionHandler: ");
           System.out.println(ex);
        }
    }
}
