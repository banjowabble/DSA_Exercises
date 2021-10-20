package Exercise123;
import edu.princeton.cs.algs4.*;

import java.util.Arrays;
import java.util.Random;

public class Merge {
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean less(int v, int w) {
        return v < w;
    }

    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public static void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void testTestData() {
        In in = new In("D:\\DSAlib\\algs4-data\\1Mints.txt");
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
        In in = new In("D:\\DSAlib\\algs4-data\\1Kints.txt");
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
        testTestData();
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
