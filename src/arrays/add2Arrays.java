package arrays;

import java.util.Arrays;

public class add2Arrays {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {9};

        int[] ans = addArrays(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] addArrays(int[] arr1, int[] arr2) {

        int m = arr1.length;
        int n = arr2.length;

        int[] ans = new int[Math.max(m, n)];
        int k = 0;

        int i= m - 1, j= n - 1;
        int carryOver = 0;
        while (i >= 0 && j >= 0) {
            int sum = arr1[i] + arr2[j] + carryOver;
            carryOver = sum / 10;
            ans[k++] = sum % 10;
            i--;
            j--;
        }

        while (i >= 0) {
            int sum = arr1[i] + carryOver;
            carryOver = sum / 10;
            ans[k++] = sum % 10;
            i--;
        }

        while (j >= 0) {
            int sum = arr2[j] + carryOver;
            carryOver = sum / 10;
            ans[k++] = sum % 10;
            j--;
        }

        reverseArr(ans, 0, ans.length-1);

        return ans;
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


}
