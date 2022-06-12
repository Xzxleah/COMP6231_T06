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
            outClient = new PrintStream(clientSocket.getOutputStream());

            // TODO Establish a TCP connection with a server which is running on port number(i.e portServer) provided and create a buffers to read and write



            while (true) {
                //TODO read the data which client sends and pass it to the server for processing of that data. Once, it is processed then return it to the client back.


            }


        } catch (IOException ex) {
            Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
