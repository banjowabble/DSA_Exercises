import edu.princeton.cs.algs4.*;

public class SelectionSort {
    public static void sort (int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exchange(a, i, min);
        }
    }

    private static boolean less (int v, int w) {
        return v < w;
    }

    private static void exchange (int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        In in = new In("D:\\DSAlib\\algs4-data\\16Kints.txt");
        int[] a = in.readAllInts();
        long start = System.currentTimeMillis();
        //run something that takes time
        sort(a);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
