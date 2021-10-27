import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise7 {
    public static void exchange(List<Integer> arr, int i, int j) {
        Integer temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }

    public static int partition (List<Integer> arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        while (true)
        {
            while (arr.get(++i) < arr.get(lo)) if (i == hi) break;
            while (arr.get(lo) < arr.get(--j)) if (j == lo) break;

            if (i >= j) break;
            exchange(arr, i, j);
        }
        exchange(arr, lo, j);
        return j;
    }

    public static int betterFindMedian(List<Integer> arr, int lo , int hi, int mid) {
        if (lo == hi) return arr.get(hi);

        int part = partition(arr, lo, hi);
        if (part == mid) return arr.get(part);
        else if (part > mid) return betterFindMedian(arr, lo, part - 1, mid);
        else return betterFindMedian(arr, part + 1, hi, mid);
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        return betterFindMedian(arr, 0, arr.size() - 1, (arr.size() - 1)/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        for (Integer integer : arr) {
            System.out.print(integer + "");
        }
        System.out.println();
        //partition(arr, 0, arr.size() - 1);
        //System.out.println(betterFindMedian(arr, 0 , arr.size() - 1, (arr.size() - 1)/2));
        System.out.println(findMedian(arr));
        //exchange(arr, 0, 1);
        for (Integer integer : arr) {
            System.out.print(integer + "");
        }
    }

    //partition takes linear time (N)
    //betterFineMedian takes log(N) (cuz its similar to binarySearch)
}
