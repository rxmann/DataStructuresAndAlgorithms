package arrays;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

public class pairSum {


    public static void main(String[] args) {

        int[] arr1 = {3, 4, 7, 6};

        int[] res = twoSum (arr1, 10);

        for (int x: res) System.out.print(x+" ");

    }

    // the most optimum solution
    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // valueAt, index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};

    }


}
