
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//remember to run this shit in java7 or else hackerank gonna mark it as time limit at test 22 23
public class Exercise3 {
    public static int cookies(int k, List<Integer> A) {
        int count = 0;
        Queue<Integer> pQueue = new PriorityQueue<>(A);
        while (pQueue.size() > 1 && pQueue.peek() < k) {
            pQueue.add(pQueue.remove() + 2 * pQueue.remove());
            count++;
        }
        if (!pQueue.isEmpty() && pQueue.peek() >= k) {
            return count;
        } else {
            return -1;
        }
    }
}