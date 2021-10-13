
import java.util.*;
import java.util.Stack;

public class Exercise6 {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        int st1TotalHeight = 0;
        int st2TotalHeight = 0;
        int st3TotalHeight = 0;

        for (int i = h1.size() - 1; i >= 0; i--) {
            st1TotalHeight += h1.get(i);
            st1.push(st1TotalHeight);
        }

        for (int i = h2.size() - 1; i >= 0; i--) {
            st2TotalHeight += h2.get(i);
            st2.push(st2TotalHeight);
        }

        for (int i = h3.size() - 1; i >= 0; i--) {
            st3TotalHeight += h3.get(i);
            st3.push(st1TotalHeight);
        }

        while (true) {
            if (st1.isEmpty() || st2.isEmpty() || st3.isEmpty()) return 0;

            st1TotalHeight = st1.peek();
            st2TotalHeight = st2.peek();
            st3TotalHeight = st3.peek();

            if (st1TotalHeight == st2TotalHeight && st2TotalHeight == st3TotalHeight) return st1TotalHeight;

            if (st1TotalHeight >= st2TotalHeight && st1TotalHeight >= st3TotalHeight) st1.pop();
            else if (st2TotalHeight >= st1TotalHeight && st2TotalHeight >= st3TotalHeight) st2.pop();
            else if (st3TotalHeight >= st1TotalHeight && st3TotalHeight >= st2TotalHeight) st3.pop();
        }
    }
}
