package recursion;

import java.util.Arrays;

public class reverseStr {
    public static void main(String[] args) {
        String nae = "roman";
        char[] charr = nae.toCharArray();
        reverseStringRecursion (charr, 0, charr.length-1);
        System.out.println("Reversed string: " + new String(charr));
    }

    private static void reverseStringRecursion(char[] arr, int start, int end) {

        if (arr.length == 1) return;

        if (start > end) {
            return;
        }

        char ch = arr[start];
        arr[start] = arr[end];
        arr[end] = ch;

        reverseStringRecursion(arr, ++start, --end);

    }
}
