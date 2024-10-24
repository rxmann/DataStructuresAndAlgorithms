package stacks;

import java.util.Stack;

public class minCostStrValid {
    public static void main(String[] args) {
        int result = findMinimumCost("}}}}}{");
        System.out.println("Cost: " + result);
    }

    public static int findMinimumCost(String str) {
        // Check for odd length strings
        if (str.isEmpty() || str.length() % 2 == 1) {
            return -1; // impossible to balance if odd length
        }

        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for (char ch : str.toCharArray()) {
            if (ch == '{') {
                stack.push(ch); // push opening braces
            } else {
                // closing brace
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop(); // found a valid pair, pop it
                } else {
                    stack.push(ch); // push unmatched closing brace
                }
            }
        }

        // Now the stack contains only unbalanced braces
        int openBraces = 0, closeBraces = 0;
        while (!stack.isEmpty()) {
            if (stack.pop() == '{') {
                openBraces++;
            } else {
                closeBraces++;
            }
        }

        // To balance, we need to convert:
        // - Half of the opening braces (`openBraces / 2`)
        // - Half of the closing braces (`closeBraces / 2`)
        // Plus if there are odd numbers, we need one more conversion
        return (openBraces + 1) / 2 + (closeBraces + 1) / 2;
    }



}
