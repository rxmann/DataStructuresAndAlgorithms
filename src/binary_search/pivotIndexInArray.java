package binary_search;

public class pivotIndexInArray {

    public static void main(String[] args) {
        int[] arr = {1, 7, 2, 6, 4, 4, 2};

        int IDX = getPivotElement(arr);

        System.out.print("Pivot at Index: " + IDX);
    }


    // optimal solution
    public static int getPivotElement (int[] arr) {

        int leftSum = 0;
        int totalSum = 0;

        for (int x: arr) {
            totalSum += x;
        }

        for (int i=0; i<arr.length; i++ ) {
            int rightSum = totalSum - leftSum - arr[i];
            if (rightSum == leftSum) {
                return i;
            }
            else {
                leftSum += arr[i];
            }
        }
        return -1;
    };



    // Brute Force approach
    public static int getPivotElementBF (int[] arr) {

        for (int i=0; i<arr.length; i++) {
            System.out.println(leftSum(arr, i) + " " + rightSum(arr, i));
            if (leftSum(arr, i) == rightSum(arr, i)) {
                return i;
            }
        }

        return -1;
    };


    static int leftSum(int[] arr, int idx ) {
        int sum = 0;
        for (int i=0; i<idx; i++) {
            sum += arr[i];
        }
        return sum;
    }

    static int rightSum(int[] arr, int idx) {
        int sum = 0;
        for (int i=idx+1; i<arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


}
