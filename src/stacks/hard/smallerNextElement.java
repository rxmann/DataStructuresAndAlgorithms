package stacks.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class smallerNextElement {

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(2, 1, 4, 3);

        arr = nextSmallerElement(arr, arr.size());

        System.out.println("Output: " + arr);

    }

    static ArrayList<Integer> nextSmallerElement(List<Integer> arr, int n){

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        stack.push(-1);

        for (int i=n-1; i>=0; i--) {
            int num = arr.get(i);
            while (!stack.isEmpty() && stack.peek() >= num) {
                stack.pop();
            }
            ans.add(0, stack.peek());
            stack.push(num);
        }


        return ans;
    }
}
