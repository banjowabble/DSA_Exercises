import edu.princeton.cs.algs4.In;

public class ThreeSum {
    public static void main(String[] args) {
        In in = new In("D:\\Hoctap\\JavaProjects\\algs4-data\\1Kints.txt"); // tạo luồng đọc từ file
        int[] a = in.readAllInts();
        // xử lý dữ liệu trong mảng a
        int N = a.length;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0) System.out.println(a[i] + ", " + a[j] + ", " + a[k]);
    }
}
