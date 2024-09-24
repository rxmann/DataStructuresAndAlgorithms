package strings;

public class reverseWords {

    public static void main(String[] args) {
        String str = "the sky is blue";

        str = reverseWordsInString(str);

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

}
