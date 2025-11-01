import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocServer {
    public static void main(String[] args) throws Exception {
        System.out.println("s: Server is Started at the port : " + 9999);
        int port = 9999; // same as client
        ServerSocket ss = new ServerSocket(port);

        System.out.println("s: Server is waiting for the client Request");
        Socket s = ss.accept(); // when server accepts the client only then server will create the server side
                                // socket to connect with the client.

        System.out.println("s: Client Connected!");
        // now we will fetch data from client: we will use the BufferedReader to fetch
        // the data.
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = bf.readLine();
        System.out.println("s: Client Send : " + str);

        // now we will send back the substring back to the client upto first three
        // characters:
        String str2 = str.substring(0, 3);

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println("C: " +  str2);
        out.flush(); // must flush to forcefully send the data.
        ss.close(); // must close
    }
}