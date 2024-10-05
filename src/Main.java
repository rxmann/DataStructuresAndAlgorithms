import java.util.*;

public class Main {

    static void quickSortAlgo(int[] arr, int start, int end) {

        // base case
        if (start >= end) return;

        // find the pivot element and partition he array with
        // elements smaller at left and others at right of pivott elementt
        int pivotIndex = partitionArr(arr, start, end);

        quickSortAlgo(arr, start, pivotIndex - 1);
        quickSortAlgo(arr, pivotIndex+1, end);

    }

    private static int partitionArr(int[] arr, int start, int end) {


        int pivot = arr[start];
        int pivotIdx = start;

        // get the pivot Index: count all smaller elements within range
        for  (int i = start+1; i<=end; i++) {
            if (pivot >= arr[i]) pivotIdx++;
        }

        // swap the element at index 1 and pivot index found
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[start];
        arr[start] = temp;

        // now arrange the arr in order of smaller to left and larger to right of pivot
        int i=start; int j = end;
        while (i < pivotIdx && j > pivotIdx) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i < pivotIdx && j > pivotIdx) {
                int tempInt = arr[i];
                arr[i] = arr[j];
                arr[j] = tempInt;
                i++;
                j--;
            }
        }

        return pivotIdx;
    }


    public static void main(String[] args) {

        int[] arr = {3, 5, 4, 1, 2};
        quickSortAlgo (arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }








}