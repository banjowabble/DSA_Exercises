import java.util.ArrayList;
import java.util.List;

public class Exercise5 {
    public static void exchange(List<Integer> arr, int i, int j) {
        Integer temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    public static List<Integer> quickSort(List<Integer> arr) {
        // Write your code here

        int pivot = arr.get(0);
        int i = 0;
        int j = arr.size();
        while (true) {
            while (arr.get(++i) < pivot) {
                if (i == arr.size() - 1) break;
            }
            while (arr.get(--j) > pivot) {
                if (j == 0) break;
            }

            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, 0, j);
        return arr;

        /*int pivot = arr.get(0);
        int lt = 1;
        int gt = arr.size() - 1;
        for (int i = 1; i < arr.size() - 1; i++) {
            if (arr.get(i) < pivot) exchange(arr, i, lt++);
            else if (arr.get(i) > pivot) exchange(arr, i, gt--);
        }
        exchange(arr, 0, gt);
        return arr;*/
    }
}
