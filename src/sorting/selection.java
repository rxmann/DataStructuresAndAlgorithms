package sorting;

import java.util.Arrays;

public class selection {

    public static void main(String[] args) {
        int[] arr = { 12, 15, 10, 6, 3, 5, 4, 2 };

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++ ) {
            int minimum = i;
            for (int j = i+1; j<arr.length; j++) {
                if (arr[j] < arr[minimum]) {
                    minimum = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = temp;
        }

    }


}
