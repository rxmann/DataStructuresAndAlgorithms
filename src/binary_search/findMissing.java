package binary_search;

public class findMissing {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5};
        int ans = missingNumber (arr);
        System.out.println(ans);
    }

    public static int missingNumber(int[] arr) {
        int n = arr.length;
        int rangeSum = n * (n+1)/2;

        for (int x: arr) {
            rangeSum -= x;
        }
        return rangeSum;
    }

}
