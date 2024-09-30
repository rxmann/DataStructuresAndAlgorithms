package arrays;

import java.util.Arrays;

public class anagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int minCount = 0;
        int[] count = new int[26];
        for (int i=0; i<s.length(); i++) {
            int idxS = s.charAt(i) - 'a';
            int idxT = t.charAt(i) - 'a';
            count[idxS]++;
            count[idxT]--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        boolean ans = isAnagram("cat", "car");
        System.out.println(ans? "Yes" : "No");
    }
}
