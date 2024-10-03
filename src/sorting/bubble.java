package sorting;

import java.util.Arrays;

public class bubble {


    public static void main(String[] args) {
        // int[] arr = { 2, 5, 6, 10, 11, 12 };
        int[] arr = { 21, 17, 8, 10, 12, 4, 3, 2 };
        bubbleSortRecursion (arr, arr.length);
        // bubbleSort (arr);

        System.out.println(Arrays.toString(arr));
    }


    // keep swapping sort
    private static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j+1] < arr[j]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
                System.out.println(j + " : " + Arrays.toString(arr));
            }
            System.out.println();
            if (!swapped) break;
        }
    }

    // recursive approach
    private static void bubbleSortRecursion (int[] arr, int idx) {

        // base case
        if (idx <= 1 ) {
            return;
        }

        boolean swapped = false;
        for (int i=0; i<idx-1; i++) {
            if (arr[i] > arr[i+1]) {
                // swap
                swapped = true;
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
            // System.out.println(i + " : " + Arrays.toString(arr));
        }
        // System.out.println(swapped);

        if (!swapped) return;

        bubbleSortRecursion(arr, --idx);
    }


}
