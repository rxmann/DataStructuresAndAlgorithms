package sorting;

import java.util.Arrays;

public class quick {
    public static void main(String[] args) {
        int[] arr = {32, 38, 23, 20, 16, 15, 19, 10, 12, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        // partition
        int part = partitionArr (arr, start, end);

        // recursive calls
        quickSort(arr, start, part-1);
        quickSort(arr, part+1, end);

    }


    // partition logic
    private static int partitionArr(int[] arr, int start, int end) {

        int pivot = arr[start];

        int pivotIdx = start;
        for (int i=start+1; i<=end; i++) {
            if (arr[i] <= pivot) {
                pivotIdx++;
            }
        }

        // swap pivot with new pivot iDX
        int temp = arr[pivotIdx];
        arr[pivotIdx] = arr[start];
        arr[start] = temp;

        // left and right
        int i = start;
        int j = end;

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
}
