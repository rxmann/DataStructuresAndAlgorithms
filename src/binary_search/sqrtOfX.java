package binary_search;

public class sqrtOfX {
    public static void main(String[] args) {
        double ans  = squareRootOfFloatingPoints(31, 3);
        System.out.println("Square root: " + ans);
    }



    // square root of floating points numbers
    private static double squareRootOfFloatingPoints (int n, int precision) {

        // Step 1: int square root
        double intSqrt = squareRootOfInt(n);

        // Step 2: Set limits to find precision through binary search
        double start = intSqrt;
        double end = intSqrt + 1;

        double mid = 0.0;

        // Factor to determine precision
        // start with utmost precision of 10 ^ -3
        double precisionFactor = Math.pow(10, -precision);

        // Step 3: Perform binary search to refine the square root
        while ((end-start) > precisionFactor) {
            mid = start + (end - start) / 2;
            if (mid < n/mid) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return Math.round(mid * Math.pow(10, precision)) / Math.pow(10, precision);
    }




    // square root of integer value
    private static int squareRootOfInt (int n) {

        if (n == 0 || n == 1) return n;

        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end-start) / 2;
//            System.out.println(start + " : " + mid + " : " + end);
            if (mid < n/mid) {
                start = mid + 1;
            }
            else if (mid > n/mid) {
                end = mid - 1;
            }
            else return mid;
        }
        return end;
    }

    private static int squareRootOfBF(int n) {

        for (int i=0; i<n/2; i++) {
            if (i*i == n) {
                return i;
            }
        }
        return -1;
    }


}
