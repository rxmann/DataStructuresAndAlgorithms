package recursion;

// count ways to reach nth stairs

import java.util.HashSet;
import java.util.Set;

public class climbStairs {
    public static void main(String[] args) {
        long ans = countDistinctWaysToClimbStair (5);
        System.out.println("Distinct ways : " + ans );
    }

    private static long countDistinctWaysToClimbStair(int n) {
        // base case
        if (n == 1) return 1;
        if (n == 2) return 2;
        // recursive calls
        long ans = countDistinctWaysToClimbStair(n-1) + countDistinctWaysToClimbStair(n-2);
//        System.out.println(ans);
        return ans;
    }
}
