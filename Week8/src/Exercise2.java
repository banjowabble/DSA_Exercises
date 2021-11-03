import java.util.Scanner;

public class Exercise2 {
    /*public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        *//* Enter your code here. Print output to STDOUT. *//*
        int count = 0;
        for (int i = 0; i < A.length() / 2; i++) {
            if(A.charAt(i) == A.charAt(A.length() - i - 1)) count++;
        }
        System.out.println( (count == A.length()/2) ? "Yes" : "No") ;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        StringBuilder string = new StringBuilder(A);
        System.out.println(A.equals(string.reverse().toString()) ? "Yes" : "No");
    }
}
