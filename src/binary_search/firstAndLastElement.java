package binary_search;

import java.util.Arrays;
import java.util.List;

public class firstAndLastElement {

    public static void main(String[] args) {
        int[] arr = {12, 13, 13, 13, 25, 29};

        int idx = firstOccurence(arr, 13);
        int idx2  = lastOccurence(arr, 13);

        System.out.print("First occurence: " + idx + " ");
        System.out.print("Last occurence: " + idx2 + " ");
    }

    private static int firstOccurence (int[] arr, int target) {
        int start = 0;
        int end= arr.length-1;
        int first= -1;

        while (start <= end)  {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                first = mid;
                end = mid;
            }
            if (arr[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return first;
    }

    private static int lastOccurence (int[] arr, int target) {
        int start = 0;
        int end= arr.length-1;
        int last= -1;

        while (start <= end)  {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                last = mid;
                start = mid+1;
            }
            if (arr[mid] <= target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return last;
    }


}

