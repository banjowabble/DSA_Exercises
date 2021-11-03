import java.util.*;

public class Exercise5 {
    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder()); //since this store elements in descending order
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        List<Double> medians = new ArrayList<>(a.size());
        for (int i = 0; i < a.size(); i++) {
            medians.add(0.0);
        }
        for (int i = 0; i < a.size(); i++) {
            int number = a.get(i);
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians.set(i, getMedian(lowers, highers));
        }
        return medians;
    }

    private static Double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double)biggerHeap.peek() + smallerHeap.peek())/2;
        } else {
            return (double)biggerHeap.peek();
        }
    }

    private static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;

        if (biggerHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    private static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers) {
        if (lowers.isEmpty() || number < lowers.peek()) {
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }
}
