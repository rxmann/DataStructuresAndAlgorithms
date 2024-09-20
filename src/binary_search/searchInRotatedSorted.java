package binary_search;

public class searchInRotatedSorted {

    public static void main(String[] args) {
        int[] arr = {12, 13, 14, 17, 2, 6, 9, 11};

        int idx = search(arr, 2);

        System.out.println("Element at index: " + idx);

    }

    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }
            // sorted and lies in the left part
            else if (arr[start] <= arr[mid]) {
                System.out.println("left: " + start + " - " + mid + " - " + end);
                if (arr[start] <= target && arr[mid] >= target) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            // right part is sorted
            else {
                System.out.println("right: " + start + " - " + mid + " - " + end);
                if (arr[mid] <= target && arr[end] >= target) {
                    start = mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
