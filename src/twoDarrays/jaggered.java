package twoDarrays;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class jaggered {

    static int max (int a, int b) {
        return Math.max(a, b);
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 2)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));


        System.out.println(matrix);


    }
}
