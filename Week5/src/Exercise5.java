import java.io.*;
import java.util.*;
import java.util.Stack;

public class Exercise5 {
    /*public static class Stack<Item> {
        private Node first = null;

        private class Node {
            Item item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            return item;
        }

        void print() {
            for (Node p = first; p != null; p = p.next) {
                System.out.print(p.item + " ");
            }
        }
    }*/

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String s = "";
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            if (n == 1) {
                stack.push(s);
                s = s.concat(sc.next());
            } else if (n == 2) {
                stack.push(s);
                s = s.substring(0, s.length() - sc.nextInt());
            } else if (n == 3) {
                System.out.println(s.charAt(sc.nextInt() - 1));
            } else {
                s = stack.lastElement();
                stack.pop();
            }
        }

    }
}
