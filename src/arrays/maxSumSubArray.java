package arrays;

public class maxSumSubArray {

    public static void main(String[] args) {

        int[] arr= {100, 200, 300, 400, 500};
        int k = 4;

        int sum = findMaximumSumInKSizeSubArray(arr, k);

        System.out.println(sum);

    }

    private static int findMaximumSumInKSizeSubArray(int[] arr, int k) {

        int n = arr.length;
        if (n < k) return -1;

        int maxSum = 0;
        int windowSum = 0;

        // first window
        for (int i=0; i<k; i++) {
            windowSum += arr[i];
        }
        maxSum = windowSum;
        // slide through array
        for (int i=0; i<n-k; i++) {
            windowSum -= arr[i];
            windowSum += arr[i+k];
            maxSum =  Math.max(windowSum, maxSum);
        }

        return maxSum;
    }

}

