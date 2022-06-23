/**
 *
 * @author Jigar Borad
 *
 */
package loadbalancer;

import java.util.ArrayList;
import java.util.Random;

public class RoundRobin {

    int min;
    int max;

    ArrayList<Integer> list = new ArrayList<>();
    public RoundRobin(int min, int max) {
        this.min = min;
        this.max = max;
        for (int i = min; i <= max; i++){
            list.add(i);
        }
    }



    /**
     * there are four server defined in our program and all of them are waiting in the queue.
     * for example, queue = [6002,6003,6004,6001].
     *
     * @return the next available server port number waiting in the queue
     */
    public int next() {
        // TODO Please define a logic of Roundrobin algorithm here
        int now = list.get(0);
        int size = list.size();
        for (int i = 1; i < size; i++){
            list.set(i-1, list.get(i));
        }
        list.set(size-1,now);

        return now;
    }

    public static void main(String[] args) {
        RoundRobin RR = new RoundRobin(6001, 6004);

        System.out.println(RR.next());
        System.out.println(RR.next());
        System.out.println(RR.next());

    }

}
