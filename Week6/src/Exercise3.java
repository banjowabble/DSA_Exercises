import java.util.List;

public class Exercise3 {
    public static void insertionSort1(int n, List<Integer> arr) {
        // Write your code here
        int value = arr.get(n - 1);
        for (int i = n - 1; i > 0; i--) {
            //if the next element in front of the current index is bigger than value
            //copy that element into the current index
            if (arr.get(i - 1) > value) {
                arr.set(i, arr.get(i - 1));
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println();
            //else if the next element in front of the current index is smaller than value
            // copy value into the current index
            } else {
                arr.set(i, value);
                for (int j = 0; j < n; j++) {
                    System.out.print(arr.get(j) + " ");
                }
                System.out.println();
                return;
            }
        }
        //after looping through the entire array but still can't find arr.get(i) < value
        //therefore, the value must be added at index 0
        arr.set(0, value);
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}
