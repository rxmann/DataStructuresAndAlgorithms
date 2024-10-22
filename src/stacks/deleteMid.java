package stacks;

import java.util.Stack;

public class deleteMid {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);
        stk.push(6);

        System.out.println("Stack after");
        System.out.println(stk);

        deleteMidStack(stk, stk.size(), 0);

        System.out.println("Stack after");
        System.out.println(stk);
    
    }

    private static void deleteMidStack(Stack<Integer> stk, int length, int idx) {
        if (length / 2 == idx) {
            stk.pop();
            return;
        }

        int num = stk.pop();
        deleteMidStack(stk, length, idx+1);
        stk.push(num);

    }


}
