package arrays;

import java.util.Arrays;

public class findUnique {

    public static void main(String[] args) {
        int[] arr = { 8, 7, 2, 5, 7, 5, 8 };

        int ans = findUniqueElement(arr);

        System.out.println("Unique element: " + ans);
    }

    private static int findUniqueElement(int[] arr) {

        Arrays.sort(arr);
        for (int i=0; i<arr.length; i+=2) {
            if (arr[i] != arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }


}
