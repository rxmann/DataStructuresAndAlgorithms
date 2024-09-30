package maths;


// Divide and Conquer

// The primary reason to use modulo arithmetic in DSA is to prevent overflow when dealing with very large numbers
// or to maintain results within a fixed range

public class modulo {


    public static long fastExpo(long x, long n) {
        long result = 1;
        while (n > 0) {
            // odd exponent
            // System.out.println("Result: " + result + " X: " + x + " N: " + n );
            if ((n & 1) == 1) {
                result *= x;
            }
            // Square the base
            x *= x;
            // Divide exponent by 2
            n >>= 1;
        }
        return result;
    }


    public static void main(String[] args) {

        System.out.println(fastExpo(2, 10));

    }

}
