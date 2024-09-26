package twoDarrays;

import java.util.Arrays;
import java.util.Scanner;

public class arrays2d {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Initialization and declaration
        int[][] arr2d = new int[3][3];
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        // printing
        System.out.println(Arrays.deepToString(arr));

        // search for k in 2d arr
        int[] ans = findIn2Darr(arr, 80);
        System.out.println("Fount at index: " + ans[0] + ", " + ans[1]);


    }

    // Linear search in 2d array
    public static int[] findIn2Darr (int[][] arr2d, int k) {
        for (int i=0; i<arr2d.length; i++) {
            for (int j =0; j<arr2d[i].length; j++) {
                if (arr2d[i][j] == k) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    // taking inputs in 2d array
    public void take2DarraysInput (int[][] arr2d) {
        System.out.println("Enter the elements in 2d array:  ");
        for (int i=0; i<3; i++) {
            for (int j =0; j<3; j++) {
                // row wise i,j: column wise j,i
                arr2d[i][j] = sc.nextInt();
            }
        }
    }


    // printing 2d arrays
    public static void print2Darr (int[][] arr2d) {
        for (int i=0; i<3; i++) {
            for (int j =0; j<3; j++) {
                System.out.print(arr2d[i][j] + " ");
            }
            System.out.println();
        }
    }


}
