import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HackerRank {
    public static String balancedSums(List<Integer> arr) {
        // Write your code here
        if (arr.size() == 1) return "YES";
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arr.size(); i++) {
            sumRight += arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            sumLeft += arr.get(i);
            sumRight -= arr.get(i);
            if (sumLeft == sumRight) return "YES";
        }
        return "NO";
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minDiff = arr.get(1) - arr.get(0);
        List<Integer> result = new ArrayList<Integer>(arr.size()*2);
        result.add(arr.get(0));
        result.add(arr.get(1));
        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) < minDiff) {
                minDiff = arr.get(i + 1) - arr.get(i);
                result.clear();
            }
            if (arr.get(i + 1) - arr.get(i) == minDiff) {
                result.add(arr.get(i));
                result.add(arr.get(i + 1));
            }
        }
        return result;
    }

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            if (Collections.binarySearch(arr, arr.get(i) - k) >= 0) count++;
        }
        return count;
    }

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int result = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) result++;
            }
        }
        System.out.println(result);
    }
}
