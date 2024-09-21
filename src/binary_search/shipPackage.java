package binary_search;

public class shipPackage {

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};

        int res = shipWithinDays(arr, 2);

        System.out.println(res);

    }


    public static int shipWithinDays(int[] weights, int days) {


        int start = 0;
        int end = 0;
        // calculate the total weights
        for (int x: weights) end+=x;

        int ans = -1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (isPossibleSolution(weights, days, mid)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossibleSolution(int[] weights, int days, int mid) {

        int daysCount = 1;
        int weightsSum = 0;

        for (int i=0; i<weights.length; i++) {
            if (weightsSum + weights[i] <= mid) {
                weightsSum += weights[i];
            }
            else {
                daysCount++;
                if (daysCount > days || weights[i] > mid) {
                    return false;
                }
                weightsSum = weights[i];
            }
        }
        return true;
    }


}
