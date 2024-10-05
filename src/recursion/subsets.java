package recursion;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> result = getSubsets (nums);
        System.out.println(result);

    }


    // method to get the subsets
    private static List<List<Integer>> getSubsets(int[] nums) {
        // create a subset list
        List<Integer> subset = new ArrayList<>();
        // create a main list to store the list of subsets
        List<List<Integer>> res = new ArrayList<>();

        // call the method for logic
        solve(nums, subset, 0, res);

        return res;

    }

    private static void solve(int[] nums, List<Integer> subset, int idx, List<List<Integer>> res) {
        // base case: if we've considered all elements
        if (idx >= nums.length) {
            System.out.println(res);
            res.add(new ArrayList<>(subset));
            return;
        }

        // Exclude the current element
        solve(nums, subset, idx+1, res);

        // Include the current element
        subset.add(nums[idx]);
        solve(nums, subset, idx+1, res);

        // Backtrack by removing the last element before returning to the previous call
        subset.removeLast();

    }

}
