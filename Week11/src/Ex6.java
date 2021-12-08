import java.util.*;

// running median using binary search tree
public class Ex6 {
    static class myInteger implements Comparable<myInteger>{
        private int data;
        private int pos;

        myInteger(int data, int pos) {
            this.data = data;
            this.pos = pos;
        }

        @Override
        public int compareTo(myInteger o) {
            if (data < o.data) {
                return -1;
            } else if (data > o.data) {
                return 1;
            } else {
                return Integer.compare(pos, o.pos);
            }
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getPos() {
            return pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        // Write your code here
        List<Double> medians = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            medians.add(0.0);
        }

        TreeSet<myInteger> treeSet = new TreeSet<>();
        for (int i = 0; i < a.size(); i++) {
            myInteger myInteger = new myInteger(a.get(i), i);
            treeSet.add(myInteger);

            int size = treeSet.size();
            myInteger middleNumber = getMiddleNumber(treeSet, size);
            myInteger higher = treeSet.higher(middleNumber);
            if (size % 2 == 0) {
                medians.set(i, (double) (higher.getData() + middleNumber.getData()) / 2);
            } else {
                medians.set(i, (double) higher.getData());
            }
        }

        return medians;
    }

    private static myInteger getMiddleNumber(TreeSet<myInteger> treeSet, int size) {
        myInteger[] arr = new myInteger[size];
        arr = treeSet.toArray(arr);
        return arr[size/2];
    }
}
