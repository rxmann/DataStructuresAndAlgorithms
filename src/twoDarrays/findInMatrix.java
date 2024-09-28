package twoDarrays;

import java.util.Arrays;

import static twoDarrays.arrays2d.print2Darr;

public class findInMatrix  {

    private static int[] searchInMatrix (int[][] arr, int target) {

        int rowsLength = arr.length;
        int colsLength = arr[0].length;

        int rowIdx = 0;
        int colIdx =  colsLength - 1;

        while (rowIdx <= rowsLength-1 && colIdx >= 0 ) {


            // current value
            int current = arr[rowIdx][colIdx];
            System.out.println(rowIdx + " : " + colIdx + " = " + current);

            // check and adjust boundaries
            if ( current == target) {
                return new int[]{rowIdx, colIdx};
            }
            else if ( current < target) {
                rowIdx++;
            }
            else {
                colIdx--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Initialization and declaration
        int[][] arr = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};

        System.out.println("Original 2d Array: ");
        print2Darr(arr);

        int[] idxx = searchInMatrix (arr, 5);
        System.out.println("Element found at index: " + Arrays.toString(idxx));
    }
}
