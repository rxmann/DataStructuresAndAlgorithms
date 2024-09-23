package arrays;

public class merge2SortedArr {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6 , 8, 12};
        int[] arr2= {2, 3, 5, 7, 9, 11};

        int[] result = merge2SortedArray(arr1, arr2);

        for (int x: result) System.out.print(x + " ");
    }

    private static int[] merge2SortedArray(int[] arr1, int[] arr2) {

        int[] ans = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j <  arr2.length) {
            if (arr1[i] <= arr2[j]) {
                ans[k++] = arr1[i++];
            }
            else {
                ans[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            ans[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            ans[k++] = arr2[j++];
        }
        return ans;
    }
}
