public class Exercise5 {
    public static void insertionSort(int[] A) {
        for(int i = 1; i < A.length; i++) {
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value) { //fix j > 0 into j >= 0
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }
        printArray(A);
    }
    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
}
