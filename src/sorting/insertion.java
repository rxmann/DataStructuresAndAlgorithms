package sorting;

import java.util.Arrays;

public class insertion {
    public static void main(String[] args) {
        int[] arr = { 2, 1, 10, 6, 5, 13, 12 };

        insertionSort(arr);

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
}
