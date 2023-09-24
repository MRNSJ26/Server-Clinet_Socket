package Labs.Lab1;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception{
        try(
            //Opeing port on the machine. 
            ServerSocket serverSocket = new ServerSocket(7070);
        ) {
            System.out.println("Server is running and waiting for clients...");
            
            //waiting for the client to connect
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            //Recieving the client's input
            InputStream input = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader inFromClient = new BufferedReader(reader);     
            String messageFromClinet = inFromClient.readLine();
            System.out.println("Clients Message: " + messageFromClinet);

            //sending a replay to the client
            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            if(messageFromClinet.equals("ping")){
                System.out.println("Sending a message for the client...");
                writer.println("pong\n");
                writer.flush();
                clientSocket.close();
            } else {
                System.out.println("Sending a message for the client...");
                writer.println("Loser =)\n");
                writer.flush();
                clientSocket.close();
            }
            System.out.println("Message sent :), Bye for Now"); 
            
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}