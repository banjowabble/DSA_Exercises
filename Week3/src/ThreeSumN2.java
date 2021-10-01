import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumN2 {
    public static void findThreeSum (int[] a) {
        int n = a.length;
        boolean check = false;

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (a[l] + a[r] == - a[i]) {
                    System.out.println(a[l] + " " + a[i] + " " + a[r]);
                    l++;
                    r--;
                    check = true;
                }
                else if (a[l] + a[r] < -a[i]){
                    l++;
                }
                else {
                    r --;
                }
            }
        }
        if (!check) System.out.println("No zero sum triplets found");
    }

    public static int countThreeSum (int[] a) {
        int n = a.length;
        int count = 0;

        Arrays.sort(a);

        for (int i = 0; i < a.length; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (a[l] + a[r] == - a[i]) {
                    l++;
                    r--;
                    count++;
                }
                else if (a[l] + a[r] < -a[i]){
                    l++;
                }
                else {
                    r --;
                }
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        In in = new In("D:\\DSAlib\\algs4-data\\4Kints.txt");
        int[] a = in.readAllInts();

        Stopwatch timer = new Stopwatch();
        int count = countThreeSum(a);
        //findThreeSum(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        System.out.println("The number of zero sum triplets: " + count);
    }
}
