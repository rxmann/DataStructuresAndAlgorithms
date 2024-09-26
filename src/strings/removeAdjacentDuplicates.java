package strings;

public class removeAdjacentDuplicates {

    public static void main(String[] args) {

        String s = "abbaca";
        String ans = removeDuplicates(s);
        System.out.println(ans);
    }


    public static String removeDuplicates(String s) {

        StringBuilder  stack = new StringBuilder();

        for (char ch: s.toCharArray()) {
            if (!stack.isEmpty() && stack.charAt(stack.length() - 1) == ch) {
                stack.deleteCharAt(stack.length() - 1);
            }
            else stack.append(ch);
        }

        return stack.toString();
    }




}
