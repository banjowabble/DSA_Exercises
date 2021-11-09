import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise7 {
    // Find the pair of closet numbers but this time sort the array using merge list
    private static void merge(Integer[] a, Integer[] aux, int lo, int mid, int hi)
    {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }


    private static void sort(Integer[] a, Integer[] aux, int lo, int hi)
    {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(Integer[] a)
    {
        Integer[] aux = new Integer[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        //Collections.sort(arr);
        Integer[] a = new Integer[arr.size()];
        arr.toArray(a);
        sort(a);

        int minDiff = a[1] - a[0]; //initiate minDiff

        List<Integer> result = new ArrayList<Integer>(arr.size()*2);
        //list to store identical pairs of closet numbers
        result.add(a[0]);
        result.add(a[1]);

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i + 1] - a[i] < minDiff) {
                minDiff = a[i + 1] - a[i]; //update minDiff
                result.clear();
            }
            if (a[i + 1] - a[i] == minDiff) {
                result.add(a[i]);
                result.add(a[i + 1]);
            }
        }
        return result;
    }
}
