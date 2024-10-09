package recursion;

import java.util.ArrayList;
import java.util.List;

public class ratInMaze {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        ArrayList<String> ans = ratInMazeRecursion(matrix);
        System.out.println(ans);
    }

    private static ArrayList<String> ratInMazeRecursion(int[][] matrix) {

        if (matrix[0][0] == 0) return new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        solveMaze(matrix, matrix.length, matrix[0].length, 0, 0, visited, result, "");

        return result;
    }


    // recursive method to traverse through the matrix
    private static void solveMaze(int[][] matrix, int m, int n, int srcX, int srcY, boolean[][] visited, List<String> result, String path) {

        // base case
        if (srcX == m - 1 && srcY == n - 1) {
            result.add(path);
            return;
        }

        visited[srcX][srcY] = true;

        // go down
        int x = srcX + 1;
        int y = srcY;
        if (isTraversable(matrix, m, n, visited, x, y)) {
            solveMaze(matrix, m, n, x, y, visited, result, path + 'D');
        }

        // go right
        x = srcX;
        y = srcY + 1;
        if (isTraversable(matrix, m, n, visited, x, y)) {
            solveMaze(matrix, m, n, x, y, visited, result, path + 'R');
        }

        // go left
        x = srcX;
        y = srcY - 1;
        if (isTraversable(matrix, m, n, visited, x, y)) {
            solveMaze(matrix, m, n, x, y, visited, result, path + 'L');
        }

        // go up
        x = srcX - 1;
        y = srcY;
        if (isTraversable(matrix, m, n, visited, x, y)) {
            solveMaze(matrix, m, n, x, y, visited, result, path + 'U');
        }

        visited[srcX][srcY] = false; // backtrack
    }


    // Method to check the possibility of traversal in the new X AND Y coordinate or index
    private static boolean isTraversable(int[][] matrix, int m, int n, boolean[][] visited, int x, int y) {

        // check for a valid index in side the matrix
        if ((x < m && x >= 0) && (y >= 0 && y < n)) {
            // if the index is open and not visited
            if (matrix[x][y] == 1 && (!visited[x][y])) {
                return true;
            }
        }

        return false;
    }
}
