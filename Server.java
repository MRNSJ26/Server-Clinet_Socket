package Labs.Lab1;
import java.io.*;
import java.net.*;


public class Server {
    public static void main(String[] args) throws Exception{
            ServerSocket serverSocket = new ServerSocket(7070);
    

            System.out.println("Server is running and waiting for clients...");
            
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");


            OutputStream outputStream = clientSocket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);

            InputStream input = clientSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(input);
            BufferedReader inFromClient = new BufferedReader(reader);     
            String messageFromClinet = inFromClient.readLine();

            System.out.println("Clients Message: " + messageFromClinet);

            if(messageFromClinet.equals("ping")){
                System.out.println("Sending a message for the client...");
                writer.write("pong\n");
                writer.flush();
                clientSocket.close();
            }        
            System.out.println("Message sent :), Bye for Now");
       
         // InputStream input = clientSocket.getInputStream(); 
        // InputStreamReader reader = new InputStreamReader(input); 
        // int character; 
        // StringBuilder data = new StringBuilder(); 
        // while((character = reader.read()) != -1) {
        //     data.append((char) character); 
        // }


        // OutputStream output = s.getOutputStream();
        // OutputStreamWriter writer = new OutputStreamWriter(output);
        // writer.write("Hello from server");
        // writer.flush();

        // InputStream input  = s.getInputStream();
        // InputStreamReader reader = new InputStreamReader(input);
        // System.out.println(reader.read());
    }}
    
