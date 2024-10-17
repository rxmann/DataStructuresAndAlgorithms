package arrays;

import java.util.*;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.

public class tripletSum {


    public static void main(String[] args) {

        int[] arr1 = {-1,0,1,2,1,-2};

        List<List<Integer>> res = tripletSumOptimized (arr1);

        System.out.println(res);

    }

    public static List<List<Integer>> tripletSumOptimized (int[] arr) {

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        List<List<Integer>> res = new ArrayList<>();

        int len = arr.length;

        for (int i=0; i<len; i++) {

            if (i > 0 && arr[i] == arr[i-1] ) {
                continue;
            }
            System.out.println(i);
            int j = i+1;
            int k = len-1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum == 0) {
                    res.add(List.of(arr[i], arr[j], arr[k]));
                    while (j<k && arr[j] == arr[j+1]) j++;
                    while (j<k && arr[k] == arr[k-1]) k--;

                    j++;
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return res;
    }


    public static List<List<Integer>> tripletSumBF (int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = arr.length;
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                for (int k=j+1; k<len; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);

                        // avoid duplicates in different order
                        Collections.sort(temp);
                        if (!ans.contains(temp)) {
                            ans.add(temp);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
