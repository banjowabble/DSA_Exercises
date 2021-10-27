import java.util.ArrayList;
import java.util.List;

public class Exercise2 {
    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            result.add(0);
        }
        for (int i = 0; i < arr.size(); i++) {
            int value = result.get(arr.get(i)); //Integer objects are immutable (bất biến)
            value += 1;
            result.set(arr.get(i), value);
        }
        return result;
    }

    public static void main(String[] args) {
        List <Integer> result = new ArrayList<>();
        System.out.println(result.get(0));
    }
}
