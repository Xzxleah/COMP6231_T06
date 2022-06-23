/**
 *
 * @author Jigar Borad
 *
 */
package loadbalancer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Task implements Runnable {

    Socket clientSocket;
    int portServer;

    public Task(Socket clientSocket, int port) {
        this.clientSocket = clientSocket;
        this.portServer = port;
    }

    public void run() {

        System.out.println("Task has started");

        String Line = null;
        try {
            /* Buffers of client */
            BufferedReader inClient = null;
            PrintStream outClient = null;
            inClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // transport the server response data from server side to client side
            outClient = new PrintStream(clientSocket.getOutputStream());

            // TODO Establish a TCP connection with a server which is running on port number(i.e portServer) provided and create a buffers to read and write
            Socket serverSocket = new Socket(clientSocket.getInetAddress(), portServer);
            BufferedReader inServer = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            // transport the Client input data from client side to server side
            PrintStream outServer = new PrintStream(serverSocket.getOutputStream());

            while (true) {
                //TODO read the data which client sends and pass it to the server for processing of that data. Once, it is processed then return it to the client back.
                String inputFromUser = inClient.readLine();
                if (inputFromUser != null){
                    // Send input to Server from client
                    outServer.println(inputFromUser);
                    outServer.flush();
                    // Print out the response from server to client
                    String response = inServer.readLine();
                    outClient.println(response);
                    outClient.flush();
                }


            }


        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
