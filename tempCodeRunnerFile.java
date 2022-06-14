import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoServer {
    public static void main(String args[]) throws IOException {
        try {
            ServerSocket ss = new ServerSocket(2784);
            System.out.println("Server is waiting for the client to connect");
            Socket sk = ss.accept();
            System.out.println(("Connection Established"));

            BufferedReader keyr = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);

            // Server reading the message from client through its input stream/

            InputStreamReader isr = new InputStreamReader(sk.getInputStream());
            BufferedReader ser_receive = new BufferedReader(isr);
            String send, receive;
            while (true) {

                if ((receive = ser_receive.readLine()) != null)
                    System.out.println("Client " + receive);

                send = keyr.readLine();
                pw.println(send);

                if (send.equals("bye")) {
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            throw new IOException("Problem reading a line", e);
        }
    }
}