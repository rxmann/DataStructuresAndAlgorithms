package sorting;

import java.util.Arrays;

// valid for small array size

public class selection {

    public static void main(String[] args) {
        int[] arr = { 12, 15, 10, 6, 3, 5, 4, 2 };

        // selectionSort(arr);
        selectionSortRecursion(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++) {
            int minIdx = i;
            // find the minimum value' index here
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[minIdx] ) {
                    minIdx = j;
                }
            }
            // swap with the current index
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

    }


    private static void selectionSortRecursion (int[] arr, int idx) {

        if (idx == arr.length-1) {
            return;
        }

        int minIdx = idx;
        // iterate from sorted to end of array to find the minimum value's index
        for (int i=idx+1; i<arr.length; i++) {
            if (arr[i] < arr[minIdx]) {
                // mark the minimum value
                minIdx = i;
            }
        }

        // swap with the current index
        int temp = arr[idx];
        arr[idx] = arr[minIdx];
        arr[minIdx] = temp;

        selectionSortRecursion(arr, ++idx);
    }


}
