package sorting;

import java.util.Arrays;

public class bubble {


    public static void main(String[] args) {
        int[] arr = { 2, 1, 10, 6, 5, 12, 12 };

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }


    // keep swapping sort
    private static void bubbleSort(int[] arr) {

        for (int i=0; i<arr.length-1; i++) {
            boolean swapped = false;
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j+1] > arr[j]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }



    }


}
