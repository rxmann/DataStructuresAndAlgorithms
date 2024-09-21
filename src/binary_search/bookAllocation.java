package binary_search;

public class bookAllocation {


    public static void main(String[] args) {
        int[] books = {10, 20, 30, 40};

        int res = allocateBooks(books, 2);

        System.out.println(res);

    }

    private static int allocateBooks(int[] books, int students) {

        int start = 0;
        int end = 0;
        // calculate the end range of books pages
        for (int x: books) end+=x;

        int ans = 0;

        // now binary search from page 0 to totalPages
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ( isPossibleToAllocate(books, students, mid) ) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return ans;
    }


    // check if the current mid can allocate
    private static boolean isPossibleToAllocate(int[] books, int students, int mid) {
        int studentsCount = 1;
        int tempSum = 0;

        for (int i=0; i<books.length; i++) {

            if (tempSum + books[i] <= mid) {
                tempSum += books[i];
            }
            else {
                studentsCount++;

                if (studentsCount > students || books[i] > mid ) {
                    return false;
                }

                tempSum = books[i];
            }
        }

        return true;
    }


}
