package recursion;

public class binarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 12, 17, 19, 45, 67};
        int idx = searchWithBinarySearch(arr, 0, arr.length-1, 12);
        System.out.println("Index: " + idx);
    }

    private static int searchWithBinarySearch(int[] arr, int start, int end, int target) {


        // base case: not found till here
        if (start > end) {
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }
        else if (arr[mid] > target) {
            end = mid - 1;
        }
        else {
            start = mid + 1;
        }

        return searchWithBinarySearch(arr, start, end, target);
    }


}
