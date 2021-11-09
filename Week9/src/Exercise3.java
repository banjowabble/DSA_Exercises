import java.util.HashSet;
import java.util.Scanner;

public class Exercise3 {
    //print out the number of distinct pairs suing HashSet
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        String[] pair_left = new String[t];
        String[] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = scanner.next();
            pair_right[i] = scanner.next();
        }

        HashSet<String> pairs = new HashSet<>(t);

        for(int i = 0; i < t; i++)
        {
            pairs.add("(" + pair_left[i] + " " + pair_right[i] + ")" );
            System.out.println(pairs.size());
            //A hash table stores information by using a mechanism called hashing.
            // In hashing, the informational content of a key is used to determine a unique value, called its hash code.
            //The hash code is then used as the index at which the data associated with the key is stored.
            // The transformation of the key into its hash code is performed automatically.
        }
    }
}
