package arrays;

public class minMax {


    static void getMaxAndMinInArr(int[] arr) {
        int smallest = arr[0];
        int largest = smallest;
        for (int i=1; i<arr.length; i++) {
            int curr = arr[i];
            largest = Math.max(curr, largest);
            smallest = Math.min(curr, smallest);

//            if (curr >= largest) {
//                largest = curr;
//            }
//            else if (curr <= smallest) {
//                smallest = curr;
//            }
        }
        for (int i=0; i<arr.length; i++) {
            arr[i] = arr[i] + 1;
        }

        System.out.println("Min: " + smallest + " Max: " + largest);
    }


    public static void main(String[] args) {
        int[] arr = { 91, 27, 3, 6, 99, 24, 56 };
//        int[] arr = { 0, 0, 0, 0, 0 };
        getMaxAndMinInArr(arr);


    }

}
