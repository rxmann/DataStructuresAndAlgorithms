package strings;

import java.util.Scanner;

public class SmallAndLargeSubstring {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for (int i=0; i<s.length() - (k); i++) {
                String temp = s.substring(i, i+k); 
                int checks = temp.compareTo(smallest);
                int checkl = temp.compareTo(largest);
                if (checkl >= 0) {
                        largest = temp;
                }
                else if (checks <= 0) {
                        smallest = temp;
                }
                
        }
        
        
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
      
        System.out.println(getSmallestAndLargest("appple", 3));
    }
}