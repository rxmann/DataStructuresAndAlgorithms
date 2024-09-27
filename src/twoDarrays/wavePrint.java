package twoDarrays;

import java.util.Arrays;

public class wavePrint {

    public static void main(String[] args) {

        // Initialization and declaration
        int[][] arr = {{1, 2, 3, 10}, {4, 5, 6, 12}, {7, 8, 9, 11}};

        System.out.println(Arrays.deepToString(arr));
        // Print Wave Pattern Down Up Down
        printWavePatternDownUp (arr);
    }


    // Print method for colum wise down and up order
    private static void printWavePatternDownUp(int[][] arr) {

        for (int i=0; i<arr[0].length; i++) {

            if (i % 2 == 0) {
                for (int[] x : arr) {
                    System.out.print(x[i] + " ");
                }
            }
            else {
                for (int j=arr.length-1; j>=0; j--) {
                    System.out.print(arr[j][i] + " ");
                }
            }

        }

    }

}
