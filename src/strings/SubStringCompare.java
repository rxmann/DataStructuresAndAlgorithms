package strings;

import java.util.Scanner;

public class SubStringCompare {

    public static String getSmallestAndLargest(String s, int k) {
            
       String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        int i = 0;
        while (i < s.length()-(k-1)) {
                
           String temp = s.substring(i, i+k);
                
                if (temp.compareTo(smallest) <= 0 ) {
                        smallest = temp;
                }
                else if (temp.compareTo(largest) >= 0 ) {
                        largest = temp;
                }
                
                i++;
                
        }
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}