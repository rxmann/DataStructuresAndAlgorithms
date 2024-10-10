package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given an array of sorted integers "nums" and an integer "target", return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in 1 indexed format [1, 2] for 0th and 1st index sum

// recommended: Two Pointers, Binary Search

public class pairSumII {


    public static void main(String[] args) {

        int[] arr1 = {3, 4, 6, 9};

        int[] res = twoSum (arr1, 10);

        System.out.println(Arrays.toString(res));

    }

    // the most optimum solution
    public static int[] twoSum(int[] nums, int target) {

        int start = 0; int end = nums.length-1;

        while (start < end) {

            int sum = nums[start] + nums[end];
            // target found
            if (sum == target) return new int[]{start+1, end+1};
            // target greater
            else if (sum < target) {
                start++;
            }
            // sum is greater, decrease the sum
            else {
                end--;
            }
        }

        return new int[0];

    }


}
