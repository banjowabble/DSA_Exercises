import java.util.HashSet;

public class Ex4 {
    public static int pairs(int k, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) set.add(i);
        int result = 0;
        for (Integer i : set) {
            result += (set.contains(i + k)) ? 1 : 0;
        }
        return result;
    }
}
