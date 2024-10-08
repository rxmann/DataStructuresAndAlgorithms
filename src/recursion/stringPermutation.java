package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class stringPermutation {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, 0);
        System.out.println(ans);
    }


    private static void permute (int[] nums, List<List<Integer>> ans, int idx) {
        // base case
        if (idx == nums.length) {
            ans.add(new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())));
            return;
        }

        // recursion
        for (int i=idx; i<nums.length; i++) {
            swapArrElements(nums, i, idx);
            permute(nums,  ans, idx+1);
            // back track
            swapArrElements(nums, i, idx);
        }
    }


    private static void swapArrElements (int[] arr, int a, int b ) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
