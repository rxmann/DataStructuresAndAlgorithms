package arrays;

import java.util.*;

public class findDuplicates {


    public static void main (String[] args) {
        List<Integer> arr1 = new ArrayList<>(Arrays.asList(8, 5, 8, 17, 5, 17, 13, 91, 13));
        List<Integer> result1 = findDuplicateElements1(arr1);

        int[] arr2 = {1, 2, 3, 2, 3, 1, 6, 8, 7, 7};
        List<Integer> result2 = findDuplicateElements2(arr2);

        int[] arr3 = {1, 2, 6, 3, 2, 4, 5};
        int result3 = findDuplicateElements3(arr3);
        System.out.print("Duplicate Result: " + result3);

    }



    // if only one duplicate element [1, 2, 2, 3, 4]
    static int findDuplicateElements3 (int[] arr) {

        int ans = 0;

        for (int j : arr) {
            System.out.println(ans + "^" + j + " = " + (ans^j) + " " );
            ans = ans ^ j;
        }
        System.out.println("\n\n");
        for (int i=1; i<arr.length; i++) {
            System.out.println(ans + "^" + i + " = " + (ans^i) + " " );
            ans = ans ^ i;
        }

        return ans;

    }



    static List<Integer> findDuplicateElements2 (int[] arr) {

        List<Integer> dup = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            int idx = Math.abs(arr[i]);
//            System.out.println(idx);
            if (arr[idx-1] < 0) {
                dup.add(idx);
            }
            else {
                arr[idx-1] *= -1;
            }
        }
        return dup;

    }

    static List<Integer> findDuplicateElements1 (List<Integer> arr) {

        Collections.sort(arr);

        List<Integer> list = new ArrayList<>();
        int p = 0;
        for (int i=0; i<arr.size()-1; i++) {
            if (Objects.equals(arr.get(i), arr.get(i + 1))) {
                list.add(arr.get(i));
                i++;
            }
        }

        return list;

    }








}
