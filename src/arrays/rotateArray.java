package arrays;

import java.util.Arrays;

public class rotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5 };

        rotateArrayByKbyReversing (arr, 3);

        System.out.println(Arrays.toString(arr));

    }

    // 3:
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;  // Handle cases where k is greater than the length of the array
        int count = 0;  // To track how many elements have been placed correctly

        for (int start = 0; count < n; start++) {
            int current = start;
            int prevValue = nums[start];

            do {
                int nextIndex = (current + k) % n;  // Find the next index for rotation
                int temp = nums[nextIndex];  // Store the value at next index
                nums[nextIndex] = prevValue;  // Move the current value to the next index
                prevValue = temp;  // Update the previous value to be placed in the next cycle
                current = nextIndex;  // Move to the next index
                count++;  // Increase the count of placed elements
            } while (start != current);  // Stop when the cycle completes
        }
    }


    // 2: reverse ranges on k th index
    private static void rotateArrayByKbyReversing (int[] arr, int k) {
        int n = arr.length;
        if (n == 1 || n == 0) return;

        k = k % n;
        if (k == 0) return;

        reverseArr(arr, 0, n - 1);
        reverseArr(arr, 0, k - 1);
        reverseArr(arr, k, n - 1);
    }


    // 2: array rotation
    static void reverseArr(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }



    // 1: BRUTE FORCE BY USING ADDITIONAL N SPACE
    private static void rotateArrayByKBF (int[] arr, int k) {
        int len = arr.length;
        int[] ans = new int[len];
        for (int i=0; i<len; i++) {
            ans[(i+k)%len] = arr[i];
        }

        arr = ans;
    }


}
