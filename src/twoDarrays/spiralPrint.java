package twoDarrays;

import java.util.ArrayList;
import java.util.List;

import static twoDarrays.arrays2d.print2Darr;

public class spiralPrint {


    public static void main(String[] args) {

        // Initialization and declaration
        int[][] arr = {{1, 2, 3, 10}, {4, 5, 6, 12}, {7, 8, 9, 11}};

        System.out.println("Original 2d Array: ");
        print2Darr(arr);

        // Print Wave Pattern Down Up Down
        List<Integer> ans= spiralOrder (arr);
        System.out.println(ans);
    }


    public static List<Integer> spiralOrder(int[][] arr) {

        // initialize array to store the spiral numbers in order
        List<Integer> ans = new ArrayList<>();

        int cols = arr[0].length;
        int rows = arr.length;

        // indexes to traverse in spiral path
        int startRow = 0;
        int startCol = 0;
        int endRow = rows - 1;
        int endCol = cols - 1;

        // traverse the 2d array until they merge at the center
        while (startRow <= endRow && startCol <= endCol) {

            // traverse the top row [left to right]
            for (int i=startCol; i<=endCol; i++) {
                ans.add(arr[startRow][i]);
            }
            startRow++;

            // traverse the right column [up to down]
            for (int i=startRow; i<=endRow; i++) {
                ans.add(arr[i][endCol]);
            }
            endCol--;

            // traverse the bottom row [right to left]
            if (startRow <= endRow) {
                for (int i=endCol; i>=startCol; i--) {
                    ans.add(arr[endRow][i]);
                }
                endRow--;
            }

            // traverse the left column [bottom to up]
            if (startCol <= endCol) {
                for (int i=endRow; i>=startRow; i--) {
                    ans.add(arr[i][startCol]);
                }
            }
            startCol++;

        }
        return ans;
    }


}
