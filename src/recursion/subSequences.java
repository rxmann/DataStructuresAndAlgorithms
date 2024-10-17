package recursion;

import java.util.ArrayList;
import java.util.List;

public class subSequences {
    public static void main(String[] args) {
        String str = "abc";
        List<String> ans = getSubSequencesInString (str);
        System.out.println(ans);
    }

    private static List<String> getSubSequencesInString(String str) {
        List<String> output = new ArrayList<>();

        solve(str, 0, output, "");

        return output;
    }

    private static void solve (String str, int idx, List<String> output, String sequence) {
        if (idx >= str.length() ) {
            output.add(sequence);
            return;
        }

        // excludes
        solve(str, idx+1, output, sequence);
        // include
        sequence += (str.charAt(idx));
        solve(str, idx+1, output, sequence);

    }
}
