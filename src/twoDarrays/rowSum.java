package twoDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class rowSum {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialization and declaration
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // get row sum
        int[] ansArr = rowWiseSum (arr);
        System.out.println("Row sum: " + Arrays.toString(ansArr));

        // get largest row sum
        int ans = largestRowSum(arr);
        System.out.println("Largest Row sum: " + ans);


    }


    // row wise sum of 2d array
    private static int largestRowSum (int[][] arr2d) {
        int ans = -1;
        for (int i=0; i<arr2d.length; i++) {
            int sum = 0;
            for (int j =0; j<arr2d[i].length; j++) {
                sum += arr2d[i][j];
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }

    // row wise sum of 2d array
    private static int[] rowWiseSum(int[][] arr2d) {
        int[] ans = new int[arr2d.length];
        for (int i=0; i<arr2d.length; i++) {
            int sum = 0;
            for (int j =0; j<arr2d[i].length; j++) {
                sum += arr2d[i][j];
            }
            ans[i] = sum;
        }
        return ans;
    }


}
