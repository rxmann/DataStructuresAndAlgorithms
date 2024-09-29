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

    public static void main(String[] args) {

        int ans = GCD (24, 72);
        System.out.println(ans);

    }

}
