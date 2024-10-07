package recursion;

import java.util.ArrayList;
import java.util.List;

public class stringPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();
        permute(nums, ans, new ArrayList<>());
        System.out.println(ans);
    }

    private static void permute (int[] nums, List<List<Integer>> ans, List<Integer> temp) {
        // base case
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // recursion
        for (int i=0; i<nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            permute(nums,  ans, temp);
            // back track
            temp.removeLast();
        }
    }
}
