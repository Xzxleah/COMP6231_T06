/**
 *
 * @author Jigar Borad
 *
 */
package loadbalancer;

public class RoundRobin {

    int min;
    int max;

    public RoundRobin(int min, int max) {
        this.min = min;
        this.max = max;
    }



    /**
     * there are four server defined in our program and all of them are waiting in the queue.
     * for example, queue = [6002,6003,6004,6001].
     *
     * @return the next available server port number waiting in the queue
     */
    public int next() {
        // TODO Please define a logic of Roundrobin algorithm here

        return 0;
    }

    public static void main(String[] args) {
        RoundRobin RR = new RoundRobin(6001, 6004);
        System.out.println(RR.next());
        System.out.println(RR.next());
        System.out.println(RR.next());

    }

}
