import java.io.*;
import java.util.*;

//simple text editor
public class Exercise5 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        String s = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < q; i++) {
            int n = sc.nextInt();
            if (n == 1) {
                stack.push(s); //save the previous state of the string into the stack
                s = s.concat(sc.next());
            } else if (n == 2) {
                stack.push(s); //save the previous state of the string into the stack
                s = s.substring(0, s.length() - sc.nextInt());
            } else if (n == 3) {
                System.out.println(s.charAt(sc.nextInt() - 1)); //no need to save since a print function have no impact on the string
            } else {
                s = stack.lastElement(); //reverse string back to its previous state that was last saved on top of the stack
                stack.pop(); //delete the new state
            }
        }
    }
}
