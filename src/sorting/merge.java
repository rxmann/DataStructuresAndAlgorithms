package sorting;

import java.util.Arrays;

public class merge {
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 2};
        mergeSortRecursion(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSortRecursion (int[] arr, int start, int end) {

        // base case
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        // recursion of partitions
        mergeSortRecursion(arr, start, mid);
        mergeSortRecursion(arr, mid + 1, end);
        // merge the with tail recursion
        mergeTwoSortedArrs(arr, start, mid, end);

    }

    private static void mergeTwoSortedArrs (int[] arr, int start, int mid, int end) {

        if (start > end) return;

        // copy the ranges into new arrays
        int[] arr1 = new int[mid - start + 1];
        int[] arr2 = new int[end - mid];

        for (int i=0; i<arr1.length; i++) {
            arr1[i] = arr[start + i];
        }
        for (int i=0; i<arr2.length; i++) {
            arr2[i] = arr[mid+1+i];
        }

        // time for sorting two sorted arrays
        int i = 0;
        int j = 0;

        // original array's index to sort
        int idx = start;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[idx++] = arr1[i];
                i++;
            }
            else {
                arr[idx++] = arr2[j];
                j++;
            }
        }

        while (i < arr1.length) {
            arr[idx++] = arr1[i];
            i++;
        }
        while (j < arr2.length) {
            arr[idx++] = arr2[j];
            j++;
        }

    }

}
