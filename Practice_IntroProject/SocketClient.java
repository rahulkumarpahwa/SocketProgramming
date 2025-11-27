import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 9999);
            System.out.println("Client : " + "Connection with server started!");

            // sending data to the client:
            OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
            PrintWriter out = new PrintWriter(os);
            out.println("Hello!");
            out.flush();

            // getting the data back:
            BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String result = bf.readLine();
            System.out.println("Server : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
