package sorting;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr = {32, 38, 23, 20, 16, 15, 19, 10, 12, 1};
        mergeSortRecursion(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 3, 5, 2, 4, 6};
        mergeTwoSortedArrays(arr1, 2, 3);
        System.out.println(Arrays.toString(arr1));
    }

    public static void mergeSortRecursion (int[] arr, int start, int end) {


        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSortRecursion(arr, start, mid);
        mergeSortRecursion(arr, mid+1, end);

        mergeTwoSortedArrays(arr, start, end);

    }

    private static void mergeTwoSortedArrays(int[] arr, int start, int end) {

        if (start > end) return;

        int mid = start + (end - start) / 2;

        int[] arr1 = new int[mid-start+1];
        int[] arr2 = new int[end - mid];

        // Fill the temp arrays
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[start + i];
        }
        for (int j = 0; j < arr2.length; j++) {
            arr2[j] = arr[mid + 1 + j];
        }

        // merge them
        int i = 0;
        int j = 0;
        int k = start;
        while (i<arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                arr[k++] = arr1[i];
                i++;
            }
            else {
                arr[k++] = arr2[j];
                j++;
            }
        }

        // arr1
        while (i<arr1.length ) {
            arr[k++] = arr1[i];
            i++;
        }

        // arr2
        while (j < arr2.length) {
            arr[k++] = arr2[j];
            j++;
        }
    }

}
