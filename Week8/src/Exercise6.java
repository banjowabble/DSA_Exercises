import java.util.*;

public class Exercise6 {
    public static void countFrequency(String string) {
        Map<String, Integer> map = new TreeMap<>();

        String[] arr = string.split(" ");

        for (String s : arr) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for(Map.Entry<String,Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey() + " - "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        String string = "lmao damn lmao moment bruh damn bruh";
        countFrequency(string);
    }
}
