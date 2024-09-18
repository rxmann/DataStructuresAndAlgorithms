package arrays;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

public class tripletSum {


    public static void main(String[] args) {

        int[] arr1 = {3, 4, 7, 6};

        int[] res = tripletSum (arr1, 10);

        for (int x: res) System.out.print(x+" ");

    }

    // the most optimum solution
    public static int[] tripletSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i=0; i<nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsValue(complement)) {
                return new int[]{complement, nums[i]};
            }
            map.put(i, nums[i]);
        }
        return new int[]{};

    }
}
