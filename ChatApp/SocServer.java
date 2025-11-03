import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocServer {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();

        OutputStreamWriter os = new OutputStreamWriter(s.getOutputStream());
        PrintWriter out = new PrintWriter(os);
        out.println("Chat Started with Server!");
        out.flush();

        BufferedReader bf = new BufferedReader(new InputStreamReader(s.getInputStream()));

        Scanner sc = new Scanner(System.in);
        while (true) {
            String output = bf.readLine();
            System.out.println(output);

            String newLine = sc.nextLine();
            if (newLine.equals("exit") || newLine.equals("Exit") || newLine.equals("EXIT")) {
                out.println("Server Exiting!");
                out.flush();
                sc.close();
                ss.close();
                s.close();
                return;
            }
            out.println("Server : " + newLine);
            out.flush();
        }
    }

}
