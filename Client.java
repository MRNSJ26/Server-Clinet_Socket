package Labs.Lab1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        
            Socket s = new Socket("localhost", 7070);
            OutputStream outputStream = s.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            System.out.print("Enter a message for the server: ");
            Scanner scanner = new Scanner(System.in);
            String msgFromClient = scanner.nextLine();
            scanner.next();
            System.out.println("Client's Message: " + msgFromClient);

            System.out.println("sending a message to the Server...");
            writer.write(msgFromClient);
            writer.flush();
            System.out.println("Message is sent");

            System.out.println("Waiting for replay");
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(s.getInputStream())); 
            String messageFromServer = inFromServer.readLine();


            System.out.println(messageFromServer);
            System.out.println("Bye for now");

        // InputStream input = s.getInputStream();
        // InputStreamReader reader = new InputStreamReader(input);
        // StringBuilder data = new StringBuilder();

    }
}
