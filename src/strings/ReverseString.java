package strings;

public class ReverseString {

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }

    }

    public static void main(String[] args) {

        char[] strArr = {'a', 'd', 'o', 'l', 'f'};
        reverseString(strArr);

        System.out.println(strArr);
    }
}



