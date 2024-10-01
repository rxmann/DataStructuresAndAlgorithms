package recursion;

public class sayDigits {

    public static void main(String[] args) {
        String[] numbers = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        digitsToString(numbers, 246);
    }

    private static void digitsToString(String[] numbers, int n) {
        if (n == 0) {
            return;
        }

        // get the last digit and print the number
        int digit = n % 10;
        n = n / 10;
        digitsToString(numbers, n);
        System.out.print(numbers[digit]);
    }

}
