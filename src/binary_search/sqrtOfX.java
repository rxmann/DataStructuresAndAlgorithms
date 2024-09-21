package binary_search;

public class sqrtOfX {
    public static void main(String[] args) {
//        2147395599
        double ans  = squareRootOfFloatingPoints(31, 3);
        System.out.println("Square root: " + ans);
    }



    // square root of floating points numbers
    private static double squareRootOfFloatingPoints (int n, int precision) {

        // Step 1: Get the integer part of the square root (assumed to be implemented)
        double intSqrt = squareRootOfInt(n);

        // Step 2: Set precision and limits for binary search
        double low = intSqrt;
        double high = intSqrt + 1; // Look between intSqrt and the next integer
        double mid = 0.0;

        // Factor to determine precision, e.g., 0.001 for 3 decimal places
        double precisionFactor = Math.pow(10, -precision);

        // Step 3: Perform binary search to refine the square root
        while ((high - low) > precisionFactor) {
            mid = (low + high) / 2;
            if (mid * mid > n) {
                high = mid;
            } else {
                low = mid;
            }
        }

        // Return result rounded to 3 decimal places
        return Math.round(mid * Math.pow(10, precision)) / Math.pow(10, precision);

cls

    }



    // square root of integer value
    private static int squareRootOfInt (int n) {

        if (n == 0 || n == 1) return n;

        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = start + (end-start) / 2;
//            System.out.println(start + " : " + mid + " : " + end);
//
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
