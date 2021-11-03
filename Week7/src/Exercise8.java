public class Exercise8<Item extends Comparable<Item>> {
    private Item[] arr;
    private int K;
    Exercise8(int n) {
        arr = (Item[]) new Comparable[n];
    }
    public void insert(Item n) {
        arr[K++] = n;
    }
    public Item deleteMin(int n) {
        int min = 0;
        for (int i = 0; i < K; i++) {
            if (arr[i].compareTo(arr[min]) < 0) min = i;
        }
        exchange(arr, min, K - 1);
        Item item = arr[--K];
        arr[K] = null; //avoid loitering
        return item;
    }

    public void exchange(Item[] arr, int i, int j) {
        Item temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
