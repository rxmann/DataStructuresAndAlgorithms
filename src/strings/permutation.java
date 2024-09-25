package strings;

import java.util.Arrays;

public class permutation {

    private static boolean findStringPermutation(String s1, String s2) {
        // count array to count alphabets count in string
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];

        for (int i=0; i<s1.length(); i++) {
            int s1Idx = s1.charAt(i)  - 'a';
            s1Count[s1Idx]++;

            int s2Idx = s2.charAt(i)  - 'a';
            windowCount[s2Idx]++;
        }

        int n = s1.length();
        System.out.println(Arrays.toString(s1Count));
        for (int i=0; i<s2.length() - n; i++) {
            System.out.println(Arrays.toString(windowCount));
            if (Arrays.equals(s1Count, windowCount)) {
                return true;
            }

            if (i+n < s2.length()) {
                windowCount[s2.charAt(i) - 'a']--;
                windowCount[s2.charAt(i+n) - 'a']++;
            }

        }
        return false;
    }


    public static void main(String[] args) {

        String s2 = "edbaaoo";
        String s1 = "ab";

        boolean ans = findStringPermutation(s1, s2);
        System.out.println(ans);
    }
}
