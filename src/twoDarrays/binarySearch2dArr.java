package twoDarrays;

import java.util.Arrays;

import static twoDarrays.arrays2d.print2Darr;

public class binarySearch2dArr  {

    private static int[] binarySearchIn2Darr(int[][] arr, int target) {

        int rowsLength = arr.length;
        int colsLength = arr[0].length;

        int start = 0;
        int end =  (rowsLength * colsLength - 1);

        while (start <= end) {
            int mid = start + (end - start)/2;
            // get the row and col index
            int row = mid / colsLength;
            int col = mid % colsLength;
            // current value
            int current = arr[row][col];

            // check and adjust boundaries
            if ( current == target) {
                return new int[]{row, col};
            }
            else if ( current < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Initialization and declaration
//        int[][] arr = {{1, 2, 3, 10}, {4, 5, 6, 12}, {7, 8, 9, 11}};
        int[][] arr = {{1, 1}};

        System.out.println("Original 2d Array: ");
        print2Darr(arr);

        int[] idxx = binarySearchIn2Darr (arr, 2);
        System.out.println("Element found at index: " + Arrays.toString(idxx));
    }
}
