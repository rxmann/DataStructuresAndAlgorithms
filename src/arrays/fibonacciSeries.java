package arrays;

public class fibonacciSeries {

    public static void main(String[] args) {
        int n = getNFibonacciRecursion (5);
        System.out.println("\n" + n);
    }


    // Fibonacci Series: For loop implementation
    static int getNFibonacciForLoop(int n) {
        int last = 1;
        int beforeLast =0;
        for (int i=0; i<n; i++) {
            int curr = last + beforeLast;
            System.out.print(curr + " ");
            beforeLast = last;
            last = curr;
        }
        return beforeLast;
    }

    // Fibonacci Series: recursion implementation
    static int getNFibonacciRecursion (int n) {

        System.out.print(n + ", ");
        // base case
        if (n  <= 1 ) return n;

        // recursive calls
        int result = getNFibonacciRecursion(n-1) + getNFibonacciRecursion(n-2);
        return result;
    }



}
