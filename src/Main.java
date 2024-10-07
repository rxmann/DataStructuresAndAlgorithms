
import java.util.ArrayList;
import java.util.List;

public class Main {

    // key map to get the digit's alphabets
    static final String[] KEYMAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {

        List<String> ans = letterCombinations("23");
        System.out.println(ans);
    }

    public static List<String> letterCombinations(String digits) {

        // Store all possible combinations when pressed a series of digits
        List<String> combinations = new ArrayList<>();
        solveLetterCombination(digits, 0, combinations, new StringBuilder());

        return combinations;
    }

    private static void solveLetterCombination(String digits, int idx, List<String> combinations, StringBuilder sequence) {
        // base case
        if (idx >= digits.length()) {
            combinations.add(sequence.toString());
            return;
        }

        // get the digit at the current index
        int digit = digits.charAt(idx) - '0';
        // get the string value of the digit [2: "abc"]
        String strValue = KEYMAP[digit];

        // now that we have a string value of a digit, we can loop through each of them to get
        // recursion
        for (char ch: strValue.toCharArray()) {
            sequence.append(ch);
            solveLetterCombination(digits, idx+1, combinations, sequence);
            sequence.deleteCharAt(sequence.length() - 1);
        }

    }

}
