package stacks;

import java.util.Stack;

public class validParenthesis {

    public static void main(String[] args) {
        boolean result = isValidParenthesis("}])]");

        System.out.println("Is valid Parenthesis? " + result );
    }

    public static boolean isValidParenthesis(String s) {

        // check empty str
        if (s.isEmpty()) return false;

        if (s.length() % 2 != 0) return false;

        Stack<Character> stk = new Stack<>();

        for (char ch: s.toCharArray()) {

            // if opening bracket, add to stack
            if (ch == '(' || ch == '{' || ch == '[' ) {
                stk.push(ch);
            }
            // if closing bracket, check the top, and pop if matches
            else {
                if (stk.isEmpty()) return false; // No matching opening bracket
                char top = stk.pop();  // Directly pop and compare
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;  // Mismatch found
                }

            }
        }

        return stk.isEmpty();

    }
}
