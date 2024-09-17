package arrays;

public class swapAlternate {

    static void swapAlternateInArr (int[] arr) {
        int len = arr.length - 1;
        for (int i=0; i<len; i+=2) {
            if (i+1 >= len) break;
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 91, 27, 3, 6, 99, 24, 56 };

        swapAlternateInArr(arr);

        for (int x: arr) {
            System.out.print(x + " ");
        }
    }



}
