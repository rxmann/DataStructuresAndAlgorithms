package strings;

public class removeOccurrence {

    public static void main(String[] args) {
        String str = "aabababa";
        String subStr = "aba";

        String newStr = removeFrom (str, subStr);
        System.out.println("New String: " + newStr);

    }



    private static String removeFromUsingStack (String s, String part) {

        StringBuilder sb = new StringBuilder();
        int m;
        int n = part.length();

        for (char ch : s.toCharArray()) {
            sb.append(ch);
            m = sb.length();
            if ((m >= n) && sb.substring(m - n).equals(part) ) {
                sb.delete(m-n, m);
            }
        }

        return sb.toString();
    }

    private static String removeFrom(String s, String part) {

        int index = s.indexOf(part);
        while (index != -1) {
            // System.out.println(s.substring(0, index) +" "+ s.substring(index + part.length()));
            s = s.substring(0, index) + s.substring(index + part.length());
            index = s.indexOf(part);
        }
        return s;
    }

}
