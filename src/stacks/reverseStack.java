package stacks;

import java.util.Stack;

import static stacks.insertBottom.insertAtStkBottom;

public class reverseStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(4);
        stack.push(7);
        stack.push(9);

        System.out.println("Original Stack: " + stack);

        reverseStackStk (stack);

        System.out.println("Reversed: " + stack);
    }

    public static void reverseStackStk (Stack<Integer> stk) {

        // check empty str
        if (stk.isEmpty()) return;


        int num = stk.pop();
        reverseStackStk (stk);

        insertAtStkBottom (stk, num);

    }
}
