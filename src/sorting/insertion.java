package sorting;

import java.util.Arrays;



public class insertion {
    public static void main(String[] args) {
        int[] arr = { 3, 10, 9, 8, 7, 1, 2 };
        System.out.println(arr.length);
        // insertionSort(arr);
        insertionSortRecursion(arr, 0);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertionSort(int[] arr) {

       for (int i=1; i<arr.length; i++ ) {
           int current = arr[i];
           int j = i-1;
           while (j >= 0 && arr[j] > current ) {
               arr[j+1] = arr[j];
               j--;
           }
           arr[j+1] = current;
       }

    }


    // using recursion
    private static void insertionSortRecursion (int[] arr, int idx) {
        // Base case
        if (idx == arr.length) {
            return;
        }

        // Take the current value
        int currentValue = arr[idx];
        int i = idx - 1;

        // Shift elements to the right to create the position for the current value
        while (i >= 0 && arr[i] > currentValue) {
            arr[i + 1] = arr[i];
            i--;
        }
        // Place the current value in the correct position
        arr[i + 1] = currentValue;

        // Recursive call for the next index
        insertionSortRecursion(arr, idx + 1);
    }
}
