package stacks.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static stacks.hard.smallerNextElement.nextSmallerElement;
import static stacks.hard.smallerNextElement.previousSmallerElement;

public class largestAreaOfHistogram {
    public static void main(String[] args) {

        int[] arr = new int[]{2,1,5,6,2,3, 2, 3, 2};
        System.out.println(Arrays.toString(arr));
        int result = largestRectangleArea(arr);
        System.out.println(result);

    }

    static int[] prevSmaller (int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[heights.length];


        for (int i=0; i<heights.length; i++) {
            int current  = heights[i];
            while (!stack.isEmpty() && stack.peek() != -1 && heights[stack.peek()] >= current) {
                stack.pop();
            }

            result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }


    static int[] nextSmaller (int[] heights) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int[] result = new int[heights.length];


        for (int i=heights.length-1; i>=0; i--) {
            int current  = heights[i];
            while (!stack.isEmpty() && stack.peek() != -1 && heights[stack.peek()] >= current) {
                stack.pop();
            }

            result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }

    public static int largestRectangleArea(int[] heights) {
        int ans = -1;

        int[] prev = prevSmaller(heights);
        int[] next = nextSmaller(heights);

        for (int i=0; i<heights.length; i++) {
            if (next[i] == -1 ) {
                next[i] = heights.length;
            }
            int width = next[i] - prev[i] - 1;
            int tempArea = width * heights[i];
            ans = Math.max(tempArea, ans);
        }

        return ans;
    }

}
