package strings;

import java.util.Arrays;

public class compression {


    public static void main(String[] args) {
        char[] arr = {'a','a', 'a','b','b','c','c', 'c','c','c','c','c','c','c','c','c','c'};
        int ans = compress(arr);
        String answer = Arrays.toString(Arrays.copyOf(arr, ans));
        System.out.println(answer);
        System.out.println(ans);
    }

    public static int compress(char[] chars) {

        int i = 0;
        int ansIdx = 0;
        int n = chars.length;

        // traverse string
        while (i < n) {
            // add new character to chars arr
            chars[ansIdx++] = chars[i];

            int countIdx = i + 1;
            // check repeating characters forward
            while (countIdx < n && chars[i] == chars[countIdx]) {
                countIdx++;
            }
            // Either completed traversal or found unique
            // countIdx is last non-repeating characters for i
            // countIdx - i is frequency of repeating character at index i
            int frequencyI = countIdx - i;

            // if repeating characters greater than 1:
            if (frequencyI > 1) {
                String cnt = String.valueOf(frequencyI);
                for (char ch: cnt.toCharArray()) {
                    chars[ansIdx++] = ch;
                }
            }

            i = countIdx;

        }

        return ansIdx;
    }

}
