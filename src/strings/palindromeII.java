package strings;

public class palindromeII {

    public static void main(String[] args) {
        String str = "lcuucul";
        boolean ans = checkPalindromeII(str);
        System.out.println(ans ? "yes" : "no");
    }

    private static boolean checkPalindromeII(String str) {

        if (str.isEmpty()) {
            return true;
        }

        int start = 0;
        int end = str.length() - 1;

        int count = 0;

        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                return isPalindrome(str, start+1, end) || isPalindrome(str, start, end-1);
            }
        }
        return true;
    }


    private static boolean isPalindrome(String str, int start, int end) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
