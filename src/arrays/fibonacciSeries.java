package arrays;

public class fibonacciSeries {

    public static void main(String[] args) {
        int n = getNFibonacciRecursion(0, 1);
        System.out.println(n);
    }


    // Fibonacci Series: For loop implementation
    static void getNFibonacciForLoop(int n) {
        int last = 1;
        int beforeLast =0;
        for (int i=0; i<n; i++) {
            int curr = last + beforeLast;
            System.out.print(curr + " ");
            beforeLast = last;
            last = curr;
        }
    }

    // Fibonacci Series: For loop implementation
    static int getNFibonacciRecursion (int prev1, int prev2) {
        System.out.print(prev1 + prev2 + " ");
        return 11;
    }



}
