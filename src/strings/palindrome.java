package strings;

public class palindrome {

    public static void main(String[] args) {
        String str = "0P";
        boolean ans = checkPalindrome(str);
        System.out.println(ans ? "yes" : "no");
        System.out.println(Character.isLetterOrDigit('$'));
    }

    private static boolean checkPalindrome(String str) {
        if (str.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = str.length()-1;

        while (start <= end) {
            char first = str.charAt(start);
            char last = str.charAt(end);

            if (!Character.isLetterOrDigit(first)) {
                start++;
            }
            else if (!Character.isLetterOrDigit(last)) {
                end--;
            }
            else {
                if (Character.toLowerCase(first) != Character.toLowerCase(last)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }

}
