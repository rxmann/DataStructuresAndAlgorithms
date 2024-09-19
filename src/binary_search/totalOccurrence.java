package binary_search;


public class totalOccurrence {

    public static void main(String[] args) {
        int[] arr = {12, 13, 13, 13, 25, 29};

        int count = totalOccurencesInArr(arr, 13);

        System.out.print("Total occurence: " + count);
    }

    private static int totalOccurencesInArr (int[] arr, int target) {
        int start = 0;
        int end= arr.length-1;
        int idx = 0;

        while (start <= end)  {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                idx = mid;
                end = mid;
            }
            if (arr[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }

        int count = 0;
        while (arr[idx++] == target) {
            count++;
        }

        return count;
    }

}

