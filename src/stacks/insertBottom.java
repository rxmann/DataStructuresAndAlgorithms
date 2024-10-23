package stacks;

import java.util.Stack;

public class insertBottom {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(9);

        System.out.println(stack);

        insertAtStkBottom(stack, 1);

        System.out.println(stack);

    }

    private static void insertAtStkBottom(Stack<Integer> stack, int num) {

        if (stack.isEmpty() ) {
            stack.push(num);
            return;
        }

        int curr = stack.pop();
        insertAtStkBottom(stack, num);
        stack.push(curr);

    }


}
