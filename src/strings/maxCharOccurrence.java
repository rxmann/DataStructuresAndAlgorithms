package strings;

import java.util.Arrays;

public class maxCharOccurrence {

    public static void main(String[] args) {

        String name = "romannn";

        char ch = getMaxOccuringChar(name);

        System.out.println(ch);

    }


    public static char getMaxOccuringChar(String str)  {
        // Your code here
        int[] count = new int[26];

        for (int i=0; i<26; i++) {
            count[i] = 0;
        }

        for (int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            int idx;
            if (ch >= 'a' && ch <= 'z') {
                idx = ch - 'a';
            } else {
                idx = ch - 'A';
            }
            count[idx]++;
        }

//        System.out.println(Arrays.toString(count));
        int ans = 0;
        int max = -1;
        for (int i=0; i<26; i++) {
            if (max < count[i]) {
                max = Math.max(ans, count[i]);
                ans = i;
            }
        }

        return (char) (ans + 'a');
    }

}
