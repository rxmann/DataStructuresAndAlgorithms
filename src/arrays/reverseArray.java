package arrays;

public class reverseArray {


    static void reverseArr (int[] arr) {
        int len = arr.length;
//        for (int i=0; i< len/2; i++) {
//            int j = len - i - 1;
//            int temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
        // two pointers
        int i=0, j=len-1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        int[] arr = { 91, 27, 3, 6, 99, 24, 56, 8 };
        reverseArr(arr);

        for (int x: arr) {
            System.out.print(x + " ");
        }

        


    }

}
