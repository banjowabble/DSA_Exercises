import java.util.Scanner;
import java.util.Stack;

//implement a queue using two stacks
public class Exercise3 {
    public static class Queue<Item> {
        private Stack<Item> st1 = new Stack<>(); //store elements in normal order
        private Stack<Item> st2 = new Stack<>(); //store elements in reverse order ready to be dequeued

        //the same as push
        public void enqueue(Item e) {
            st1.push(e);
        }

        public Item dequeue() {
            //check if there are no leftover in st2 from the last dequeue
            if (st2.isEmpty()) {
                //push everything from st1 to st2 in reverse order
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
            //return the top element of st2, which is the first element of st1
            return st2.pop();
        }

        //same as dequeue but instead of popping st2 we peek it
        public void print() {
            if (st2.isEmpty()) {
                while (!st1.isEmpty()) {
                    st2.push(st1.pop());
                }
            }
            System.out.println(st2.peek());
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            if (n == 1) {
                queue.enqueue(sc.nextInt());
            } else if (n == 2) {
                queue.dequeue();
            } else if (n == 3) {
                queue.print();
            }
        }
    }
}
