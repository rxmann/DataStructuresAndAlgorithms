package strings;

import java.util.Stack;

public class removeAdjacentDuplicates {

    public static void main(String[] args) {

        String s = "abbaca";
        String ans = (String)removeDuplicates(s);
        System.out.println(ans);
    }


    public static String removeDuplicates(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            }
            else stack.add(ch);
        }

        return stack.toString();
    }


//        for (char ch: s.toCharArray()) {
//        if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == ch) {
//            stack.deleteCharAt(stack.length() - 1);
//        }
//        else stack.append(ch);
//          }

}
