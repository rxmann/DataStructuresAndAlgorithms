package arrays;

import java.util.Arrays;

public class checkRotatedAndSorted {

    public static void main(String[] args) {
        int[] arr = {2,1,3,4};

        boolean ans = checkIfArrSortedAndRotated (arr);

        System.out.println(ans);

    }

    private static boolean checkIfArrSortedAndRotated(int[] arr) {
        int count = 0;
        for (int i=0; i< arr.length-1; i++ ) {
            if (arr[i] > arr[i+1]) {
                count++;
            }
        }
        if (arr[arr.length - 1] > arr[0]) {
            count++;
        }
        System.out.println(count);
        return count <= 1;
    }


}
