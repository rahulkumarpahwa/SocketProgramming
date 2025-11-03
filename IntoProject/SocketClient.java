// this project creates the Socket between client and Server in which substring is returned upto the length 3.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    public static void main(String args[]) throws Exception {
        String ip = "localhost"; // ip of the server
        int port = 9999; // to find the particular process or application
        Socket s = new Socket(ip, port); // see the definition by crtl + click

        // once connected : client will send request to the server to perform the task

        String str = "Apple"; // we want the first three letters.
        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream()); // s.getOutputStream() is the place where
                                                                             // we are sending the stream data.

        PrintWriter out = new PrintWriter(os); // os is the place where we are printing.
        out.println(str);
        os.flush(); // as only the 512 bytes can be send via the network so we need to forcefully
                    // send it.

        // now we will print the data send by the client:
        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String output = bf.readLine();
        System.out.println("c: Data Send by the Server : " + output);

        s.close();
    }

}
