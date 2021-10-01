import edu.princeton.cs.algs4.*;

public class TwoSum {
    public static void main(String[] args) {
        In in = new In("D:\\DSAlib\\algs4-data\\8Kints.txt");
        int[] a = in.readAllInts();
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                if (a[i] + a[j] == 0) System.out.println(a[i] + " and " + a[j]);
    }
}
