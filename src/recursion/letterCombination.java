package recursion;

import java.util.ArrayList;
import java.util.List;

public class letterCombination {
    public static void main(String[] args) {

        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>(); // Return empty if digits string is empty
        }

        String[] phone_map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> combinations = new ArrayList<>();

        solveLetterCombination(digits, phone_map, 0, combinations, new StringBuilder());

        return combinations;
    }

    private static void solveLetterCombination(String digits, String[] phone_map, int idx, List<String> combinations, StringBuilder sequence) {
        // base case
        if (idx >= digits.length()) {
            combinations.add(sequence.toString());
            return;
        }

        // recursion
        int num = digits.charAt(idx) - '0';
        String value = phone_map[num];

        for (char ch : value.toCharArray()) {
            sequence.append(ch);
            solveLetterCombination(digits, phone_map, idx+1, combinations, sequence);
            sequence.deleteCharAt(sequence.length() - 1);
        }

     }

}
