package arrays;

import java.util.*;

public class uniqueOccurence {

    public static void main(String[] args) {
        int[] arr = { 8, 5, 8, 7, 5, 8 };

        boolean ans = uniqueOccurrences(arr);

        System.out.println("Unique element Count: " + (ans ? "YES" : "NO"));
    }

    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        for (int i:arr) {
            countMap.put(i, countMap.getOrDefault(i, 0)+1);
        }

        Set<Integer> countSet = new HashSet<>(countMap.values());

        return countSet.size() == countMap.size();

    }

}
