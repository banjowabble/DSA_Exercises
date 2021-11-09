import java.util.*;
import java.io.*;

class Exercise2 {
    // Search phone book using HashMap
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++)
        {
            String name = in.nextLine();
            int phone = in.nextInt();
            map.put(name, phone);
            in.nextLine();
            //This extra in.nextLine exists because after taking integer input using nextInt(),which reads integer tokens
            //,the last newLine character for that line of integer is still queued in the input buffer,
            //and we need to clear that or else the next input for the string will be an empty line.
        }
        while(in.hasNext())
        {
            String s = in.nextLine();
            if (!map.containsKey(s)) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + map.get(s));
            }
        }
    }
}