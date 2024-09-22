package binary_search;

import java.util.Arrays;

public class aggressiveCows {
    public static boolean isPossible(int[] stalls, int n, int cows, int minDist) {
        int countCows = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < n; i++) {
            if (stalls[i] - lastPosition >= minDist) {
                countCows++;
                lastPosition = stalls[i];

                if (countCows == cows) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int findMaxDistance(int[] stalls, int n, int cows) {
        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[n - 1] - stalls[0];
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (isPossible(stalls, n, cows, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] stalls = {1, 2, 8, 4, 9};
        int cows = 3;
        System.out.println("Maximum distance = " + findMaxDistance(stalls, stalls.length, cows));
    }
}
