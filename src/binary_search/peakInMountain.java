package binary_search;

public class peakInMountain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0};

        int count = findPeakInMountain(arr);

        System.out.print("Peak at: " + count);
    }

    private static int findPeakInMountain(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid = -1;
        while (start < end) {

            mid = start + (end - start) / 2;

            // peak point 1 2 [3] 2 1: come back
            if (arr[mid] > arr[mid+1]) {
                end = mid;
            }
            else  {
                start = mid+1;
            }
        }

        return start;
    }


}
