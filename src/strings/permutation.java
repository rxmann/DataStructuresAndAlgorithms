package strings;

import java.util.Arrays;

public class permutation {

    private static boolean findStringPermutation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) return false;

        // count array to count alphabets count in string
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i=0; i<s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            windowCount[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(s1Count, windowCount)) {
            return true;
        }
        for (int i=0; i<m - n; i++) {
            if (i+n < m) {
                windowCount[s2.charAt(i) - 'a']--;
                windowCount[s2.charAt(i+n) - 'a']++;
            }

            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        String s2 = "dcda";
        String s1 = "adc";

        boolean ans = findStringPermutation(s1, s2);
        System.out.println(ans);
    }
}
