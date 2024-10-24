package stacks;

import java.util.Stack;

public class redundantBrackets {
    public static void main(String[] args) {

        boolean result = findRedundantBrackets("(a+b)+(b+c)");
        System.out.println(result);

    }

    public static boolean findRedundantBrackets(String str) {

        Stack<Character> stk = new Stack<>();

        // for each character
        for (char ch: str.toCharArray()) {
            // if ch is open bracket || operator, then add to stack
            if ((ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' )) {
                stk.push(ch);
            }
            // else: check if stack has an operator and corresponding opening bracket on top
            else {
                if (ch == ')') {
                    boolean operatorFound = false;
                    while (stk.peek() != '(') {
                        char peek = stk.peek();
                        if (peek ==  '+' || peek == '-' || peek == '*' || peek == '/') {
                            operatorFound = true;
                        }
                        stk.pop();
                    }
                    if (!operatorFound) return true;
                    stk.pop();
                }
            }

        }
        return false;
    }


}
