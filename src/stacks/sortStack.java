package stacks;

import java.util.Stack;

public class sortStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);

        System.out.println("Original Stack: " + stack);

        sortTheStack (stack);

        System.out.println("Reversed: " + stack);
    }

    private static void sortTheStack(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        int num = stack.pop();

        sortTheStack(stack);

        insertAtSortedPosition(stack, num);

    }

    private static void insertAtSortedPosition(Stack<Integer> stack, int num) {

        if (stack.isEmpty()) {
            stack.push(num);
            return;
        }

        if (stack.peek() < num) {
            stack.push(num);
            return;
        }

        int temp = stack.pop();
        insertAtSortedPosition(stack, num);
        stack.push(temp);

    }


}
