package maths;

public class euclidAlgo {

    public static int GCD (int a, int b) {

        if (a == 0) return b;
        if (b == 0) return a;

        while ( a != b ) {
            if (a > b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        return a;
    }



    // GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // LCM using GCD
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {

        int ans = GCD (24, 72);
        System.out.println(ans);

    }

}
