package arrays;

import java.util.Arrays;

public class sort012 {

    public static void main(String[] args) {
        int[] arr = { 1, 0, 0, 0, 1, 1, 0, 1 };
        int[] arr2 = { 1, 2, 0, 2, 1, 2, 0, 1 };

        System.out.println(Arrays.toString(arr2));

        sort0and1and2(arr2);

        System.out.println(Arrays.toString(arr2));

    }

    private static void sort0and1(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while ( start < end ) {
            while (arr[start] == 0) {
                start++;
            }
            while (arr[end] == 1) {
                end--;
            }
            if (start < end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
    }

    private static void sort0and1and2(int[] arr) {
        int start = 0;
        int mid = 0;
        int end = arr.length - 1;
        int temp = 0;
        while ( mid <= end ) {
            if (arr[mid] == 0) {
                temp = arr[start];
                arr[start] = arr[mid];
                arr[mid] = temp;
                start++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                temp = arr[end];
                arr[end] = arr[mid];
                arr[mid] = temp;
                end--;
            }
            System.out.println(Arrays.toString(arr));

        }
    }

}
