import edu.princeton.cs.algs4.In;

import java.util.*;

public class Ex5 {
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Hashtable<Integer, Integer> brrFrequencyHashTable = new Hashtable<>();

        // Add the elements of brr and their respective frequencies to the hash table
        for (Integer integer : brr) {
            // Get an element's frequency or ,if it hasn't been added to the table, return 0
            int frequency = brrFrequencyHashTable.getOrDefault(integer, 0);
            frequency++;
            brrFrequencyHashTable.put(integer, frequency); //update the element's frequency
        }

        // Iterate through the table using elements of arr
        // Everytime we found the same elements, decrement its frequency by 1
        // Remove any element with frequency = 0 (which means they appear in both arrays).
        for (Integer integer : arr) {
            int frequency = brrFrequencyHashTable.get(integer);
            frequency--;
            if (frequency == 0) {
                brrFrequencyHashTable.remove(integer);
            } else {
                brrFrequencyHashTable.put(integer, frequency);
            }
        }

        // Convert the keys in the hashtable to a result list and sort it to return
        List<Integer> result = new ArrayList<>(brrFrequencyHashTable.keySet());
        Collections.sort(result);
        return result;
    }

    public static List<Integer> anotherMissingNumbers(List<Integer> arr, List<Integer> brr) {
        Collections.sort(arr);
        Collections.sort(brr);
        List<Integer> result = new ArrayList<>();
        int i = 0;
        for (Integer integer : brr) {
            if (i >= arr.size() || !Objects.equals(arr.get(i), integer)) {
                if (!result.contains(integer)) {
                    result.add(integer);
                }
            } else {
                i++;
            }
        }
        return result;
    }
}
