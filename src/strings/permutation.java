package strings;

import java.util.Arrays;

public class permutation {

    private static boolean findStringPermutation(String s1, String s2) {
        // count array to count alphabets count in string
        int[] count1 = new int[26];

        for (int i=0; i<s1.length(); i++) {
            int idx = s1.charAt(i)  - 'a';
            count1[idx]++;
        }

        // slide through string 2
        int i = 0;
        int windowSize = s1.length();

        // check first window
        int[] count2 = new int[26];
        while (i<windowSize) {
            int idx = s2.charAt(i++) - 'a';
            count2[idx]++;
        }

        if (Arrays.equals(count2, count1)) return true;

        // process window
        






        return false;
    }


    public static void main(String[] args) {

        String s2 = "edbaaoo";
        String s1 = "ab";

        boolean ans = findStringPermutation(s1, s2);
        System.out.println(ans);
    }
}
