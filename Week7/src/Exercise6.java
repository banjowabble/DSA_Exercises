import java.util.Scanner;

public class Exercise6 {
    public static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int lo, int hi) {
        //take the last element as pivot
        int pivot = arr[hi];
        int i = lo - 1;
        for (int j = lo; j <= hi - 1; j++) {
            if (arr[j] < pivot) {
                i += 1;
                exchange(arr, i, j);
            }
        }
        exchange(arr, i + 1, hi);
        print(arr);
        return i + 1;
    }

    public static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= 0 && hi >= 0 && lo < hi) {
            int p = partition(arr, lo, hi);

            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);
    }
}
