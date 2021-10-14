public class Exercise2 {
    public static class LinkedStack {
        private Node first = null;

        private static class Node {
            char item;
            Node next;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(char item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
        }

        public char pop() {
            char item = first.item;
            first = first.next;
            return item;
        }

        void print() {
            for (Node p = first; p != null; p = p.next) {
                System.out.print(p.item + " ");
            }
        }
    }

    //check if a string of brackets is balanced
    public static String isBalanced(String s) {
        // Write your code here
        LinkedStack leftBrackets = new LinkedStack();
        for (int i = 0; i < s.length(); i++) {
            //check for opening brackets to push into leftBrackets
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                leftBrackets.push(s.charAt(i));
            } else {
                //when there are no closing brackets left in the string
                if (leftBrackets.isEmpty()) return "NO";
                //found a closing bracket
                else {
                    char temp = leftBrackets.pop();
                    if (temp == '(' && s.charAt(i) != ')') return "NO";
                    else if (temp == '{' && s.charAt(i) != '}') return "NO";
                    else if (temp == '[' && s.charAt(i) != ']') return "NO";
                }
            }
        }
        if (leftBrackets.isEmpty()) return "YES";
        else return "NO"; //when there's one or more opening brackets left in the stack
    }
}
