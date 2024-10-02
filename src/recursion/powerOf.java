package recursion;

public class powerOf {

    public static void main(String[] args) {
        int ans = xPowerN(2, 10);
        System.out.println(ans);
    }

    private static int xPowerN (int x, int n) {

        if (n == 0) return 1;
        if (n == 1) return x;

        int ans = xPowerN(x, n/2);

        if (n%2 == 0) {
            ans = ans * ans;
        }
        else {
            ans = ans * ans * x;
        }

        return ans;
    }


}
