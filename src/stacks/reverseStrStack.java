package stacks;

import java.util.Arrays;
import java.util.Stack;

public class reverseStrStack {
    public static void main(String[] args) {

        char[] arr = {'h', 'e', 'l', 'l', 'o'};

        System.out.println(Arrays.toString(arr));

        reverseString(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void reverseString(char[] str) {

        Stack<Character> stk = new Stack<>();

        // add to stack
        for (char x: str) {
            stk.push(x);
        }

        // remove reversed order from stack
        int idx = 0;
        while ( !stk.isEmpty() ) {
            str[idx++] = stk.peek();
            stk.pop();
        }

    }
}
