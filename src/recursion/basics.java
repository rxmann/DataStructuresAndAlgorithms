package recursion;

public class basics {

    public static void main(String[] args) {
        System.out.println("Fibonacci: " + printFibonacci(30));

        int fact = getFactorial(5);
        System.out.println("Factorial: " + fact);

        int powerOf2 = powerOf(3);
        System.out.println("Power of 2: "  + powerOf2);

        coutUpTo(10);

    }


    // print the count upto N
    private static void coutUpTo(int n) {
        if (n < 1) return;
        coutUpTo(n-1);
        System.out.print(n + " ");
    }

    // print the fibonacci series
    static int printFibonacci (int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return printFibonacci(n-1) + printFibonacci(n-2);
    }



    // get factorial recursion
    private static int getFactorial(int n) {
        // base case
        if (n < 1) return 1;
        // recursion
        return n * getFactorial(n - 1);
    }


    // get power of 2
    static int powerOf (int n) {
        // base case
        if (n < 1) return 1;
        return 2 * powerOf(n - 1);
    }
}
