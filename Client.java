package Labs.Lab1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        
        try (
            //connecting to the server
            Socket s = new Socket("127.0.0.1", 7070);
        ){        
            System.out.print("Enter a message for the server: ");

            //Registering a message from the user
            Scanner scanner = new Scanner(System.in);
            String msgFromClient = scanner.nextLine();
            scanner.close();
            System.out.println("Client's Message: " + msgFromClient);
            System.out.println("sending a message to the Server...");

            //Sending the message to the server
            OutputStream outputStream = s.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(msgFromClient);
            writer.flush();
            System.out.println("Message is sent");

            //Receinvg the replay from the server
            System.out.println("Waiting for replay");
            InputStream input = s.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader bufReader = new BufferedReader(reader);
            System.out.println(bufReader.readLine());
            System.out.println("Bye for now");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
}