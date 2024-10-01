package recursion;

public class search {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 12, 17, 19, 45, 67};
        int idx = searchFor (arr, 0, 172);
        System.out.println("Index: " + idx);
    }

    private static int searchFor(int[] arr, int idx, int target) {

        if (idx == arr.length) {
            return -1;
        }

        if (arr[idx] == target) {
            return idx;
        }

        return searchFor(arr, ++idx, target);
    }
}
