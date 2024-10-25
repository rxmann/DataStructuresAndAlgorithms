package stacks.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static stacks.hard.smallerNextElement.nextSmallerElement;
import static stacks.hard.smallerNextElement.previousSmallerElement;

public class largestAreaOfHistogram {
    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(2,1,5,6,2,3);
        int result = findLargestAreaInHistogram(arr);
        System.out.println(result);

    }

    static int findLargestAreaInHistogram (List<Integer> arr) {

        int ans = 0;

        ArrayList<Integer> nextSmallest = nextSmallerElement(arr, arr.size());
        ArrayList<Integer> previousSmallest = previousSmallerElement(arr, arr.size());

        for (int i=0; i<arr.size(); i++) {
            int length = arr.get(i);

            if (nextSmallest.get(i) == -1) {
                nextSmallest.set(i, arr.size());
            }
            int breadth = nextSmallest.get(i) - previousSmallest.get(i) + 1;

            int newArea = length * breadth;

            ans = Math.max(newArea, ans);
        }

        return ans;
    }

}
