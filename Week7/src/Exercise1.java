import java.util.List;

public class Exercise1 {
    public static int introTutorial(int V, List<Integer> arr) {
        int lo = 0;
        int hi = arr.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if (V < arr.get(mid)) hi = mid - 1;
            else if (V > arr.get(mid)) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
