package recursion;

public class sum {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 8, 9, 12, 17, 19, 45, 67};
        int ans = getSum (arr, 0);
        System.out.println("Sum: " + ans);
    }

    private static int getSum(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        return arr[idx] + getSum(arr, ++idx);

    }
}
