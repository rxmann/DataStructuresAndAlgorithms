package binary_search;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {12, 13, 14, 15, 25, 27};

        int idx = binarySearch(arr, 25);

        System.out.println("Element at index: " + idx);
    }

    private static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end= arr.length-1;

        while (start <= end)  {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return -1;
    }


}
