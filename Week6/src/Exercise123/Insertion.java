package Exercise123;
import java.util.Arrays;
import java.util.Random;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdArrayIO;

public class Insertion {
    public static void sort(int[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i; j > 0; j--)
                if (less(a[j], a[j-1]))
                    exch(a, j, j-1);
                else break;
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void testTestData() {
        In in = new In("D:\\DSAlib\\algs4-data\\1Kints.txt");
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //StdArrayIO.print(a);
    }

    private static void testRandomData(int n) {
        Random rd = new Random(); // creating Random object
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt();
        }
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //StdArrayIO.print(a);
    }

    private static void testAscendingData() {
        In in = new In("D:\\DSAlib\\algs4-data\\16Kints.txt");
        int[] a = in.readAllInts();
        sort(a);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //StdArrayIO.print(a);
    }

    private static void testDescendingData() {
        In in = new In("D:\\DSAlib\\algs4-data\\32Kints.txt");
        int[] a = in.readAllInts();
        sort(a);
        reverse(a);
        //StdArrayIO.print(a);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //StdArrayIO.print(a);
    }

    private static void testEqualData(int n) {
        int[] a = new int[n];
        Arrays.fill(a, 1);
        long start = System.currentTimeMillis();
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        //StdArrayIO.print(a);
    }
    public static void main(String[] args) {
        //testTestData();
        //testRandomData(32000);
        //testAscendingData();
        //testDescendingData();
        //testEqualData(32000);
    }

    private static void reverse(int[] a) {
        int i, k, temp;
        int n = a.length;
        for (i = 0; i < n / 2; i++) {
            temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }
    }
}