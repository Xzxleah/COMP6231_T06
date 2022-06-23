/**
 *
 * @author Jigar Borad
 *
 */
package loadbalancer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loadbalancer {

    private Socket clientSocket = null;
    ServerSocket listenSocket = null;

    public Loadbalancer() {
        //TODO (optioanl), if you make change in port range. please do change in RoundRobin.java file too.
        RoundRobin RR = new RoundRobin(6001, 6004);

        try {
            listenSocket = new ServerSocket(6231);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println("I got a new Client.");
                //TODO start new task(Task class instance) and pass the client and the server(according to round-robin algorithm) as a parameter.
                // you must start new thread for each new task.
                Thread t = new Thread(new Task(clientSocket, RR.next()));
                t.start();

            }
        } catch (Exception e) {
        } finally {
            try {
                listenSocket.close();
            } catch (IOException ex) {
                Logger.getLogger(Loadbalancer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void main(String[] args) {
        Loadbalancer LB = new Loadbalancer();
    }

}
