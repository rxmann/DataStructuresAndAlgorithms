package maths;


// Divide and Conquer

// The primary reason to use modulo arithmetic in DSA is to prevent overflow when dealing with very large numbers
// or to maintain results within a fixed range

public class modulo {


    public static long fastExpo(long x, long n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) result *= x; // If n is odd
            x *= x; // Square the base
            n >>= 1; // Divide exponent by 2
        }
        return result;
    }

    // a power b
    static void fastExponentiation (int x, int n) {

        int res = 1;
        while (n > 0) {
            if ((n&1) == 1) {
                res *= x;
            }
            x *= x;
            n = n>>1;
        }

        System.out.println(res);
    }

    public static void main(String[] args) {

        fastExponentiation(2, 2);

    }

}
