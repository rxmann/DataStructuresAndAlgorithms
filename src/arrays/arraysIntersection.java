package arrays;

import java.util.*;


public class arraysIntersection {



    public static void main(String[] args) {

        int[] arr1 = {2, 4, 6, 7};
        int[] arr2 = {2, 4, 5, 9, 0, 6, 7};

        int[] res = intersectionOptimized (arr1, arr2);

        for (int x: res) System.out.print(x+" ");

    }




    public static int[] intersectionOptimized (int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();

        for (int x: arr1) {
            set.add(x);
        }

        for (int x: arr2) {
            if (set.contains(x)) {
                list.add(x);
                set.remove(x);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static int[] intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int l1 = arr1.length;
        int l2 = arr2.length;

        int idx1 = 0;
        int idx2 = 0;

        int[] res = new int[Math.min(l1, l2)];
        int i=0;

        while ((idx1 < l1) && (idx2 < l2)) {
            int a = arr1[idx1];
            int b = arr2[idx2];
            if (a == b) {
                res[i++] = a;
                idx1++;
                idx2++;
            }
            else if (a < b) {
                idx1++;
            }
            else {
                idx2++;
            }
        }
        return Arrays.copyOf(res, i);
    }


}
