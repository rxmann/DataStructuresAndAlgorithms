package sorting;

import java.util.Arrays;

// valid for small array size

public class selection {

    public static void main(String[] args) {
        int[] arr = { 12, 15, 10, 6, 3, 5, 4, 2 };

        selectionSort(arr);

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


}
