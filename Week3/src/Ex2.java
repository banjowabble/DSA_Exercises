import java.util.Random;
import java.util.Arrays;

public class Ex2 {
    public static int binarySearch(int[] a, int number) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if (number < a[mid]) high = mid - 1;
            else if (number > a[mid]) low = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int N = rand.nextInt(51);
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = rand.nextInt(100);
        }
        Arrays.sort(a);
        System.out.println(binarySearch(a, 50));
        /*for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }*/
    }
}
