package strings;

public class reverseWords {

    public static void main(String[] args) {
        String str = "the sky is blue";

        str = reverseWordsStr(str);

        System.out.println(str);

    }

    private static String reverseWordsInString(String s) {

        String[] arr = s.trim().split("\\s+");
        int i=0,j=arr.length-1;
        while(i<j) {
            String t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return String.join(" ", arr);

    }


    public static String reverseWordsStr(String s) {

        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();

        for (int i=words.length - 1; i>=0; i--) {
            sb.append(words[i]);
            
            if (i > 0) {
                sb.append(" ");
            }
            
        }

        return  sb.toString();
    }

}
