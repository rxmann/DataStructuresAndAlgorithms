package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ratInMaze {

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(Arrays.deepToString(matrix));
        ArrayList<String> ans = ratInMaze(matrix, matrix.length, matrix[0].length);
        System.out.println(ans);
    }

    private static ArrayList<String> ratInMaze(int[][] matrix, int rowSize, int columnSize) {

        if (matrix[0][0] == 0) return new ArrayList<>();

        ArrayList<String> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        solveRatInMaze (matrix, rowSize, columnSize, result, "", 0, 0, visited);

        return result;
    }

    private static void solveRatInMaze(int[][] matrix, int rowSize, int columnSize, ArrayList<String> result, String path, int x, int y, boolean[][] visited) {
        // System.out.println("solveRatInMaze(matrix, " + rowSize + ", " + columnSize + ", result, \"" + path + "\", " + x + ", " + y + ", visited);");
        // base case
        if ( x == rowSize-1 && y == columnSize-1) {
            // System.out.println("Destination Reached!!!");
            result.add(path);
            return;
        }

        // recursive calls
        // mark the current place as visited
        visited[x][y] = true;

        // explore all direction where valid
        // DOWN
        if (canTravel(matrix, rowSize, columnSize, x+1, y, visited)) {
            solveRatInMaze(matrix, rowSize, columnSize, result, path+'D', x+1, y, visited);
        }
        // RIGHT
        if (canTravel(matrix, rowSize, columnSize, x, y+1, visited)) {
            solveRatInMaze(matrix, rowSize, columnSize, result, path+'R', x, y+1, visited);
        }
        // LEFT
        if (canTravel(matrix, rowSize, columnSize, x, y-1, visited)) {
            solveRatInMaze(matrix, rowSize, columnSize, result, path+'L', x, y-1, visited);
        }
        // UP
        if (canTravel(matrix, rowSize, columnSize, x-1, y, visited)) {
            solveRatInMaze(matrix, rowSize, columnSize, result, path+'U', x-1, y, visited);
        }
        visited[x][y] = false;
    }

    private static boolean canTravel(int[][] matrix, int rowSize, int columnSize, int x, int y, boolean[][] visited) {

        // if the path lies within the row and column size
        // if the path is not visited
        // if the path is open value = 1
        if ((x >= 0 && x < rowSize) && (y >=0 && y < columnSize)) {
            return !visited[x][y] && matrix[x][y] == 1;
        }

        return false;
    }

}
