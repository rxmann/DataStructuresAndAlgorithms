package recursion;

public class isSorted {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 12, 17, 19, 45, 67};
        boolean ans = checkSorted(arr, 0);
        System.out.println("Is sorted ? " + (ans ? "Yes" : "No"));
    }

    public static boolean checkSorted (int arr[], int idx) {

        // stopping point
        if (idx == arr.length - 1) {
            return true;
        }
        // check if the progression is steady
        if (arr[idx] > arr[idx+1]) {
            return false;
        }
        return checkSorted(arr, ++idx);
    }
}
