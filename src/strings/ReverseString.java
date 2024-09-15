import java.io.*;
import java.util.*;

public class ReverseString {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
       
       int i = 0;
       int j = A.length() - 1;
       
       int isEqual = 0;
       
       while (i < j) {
               
               if (A.charAt(i) == A.charAt(j)) {
                      isEqual = 0; 
               }
               else {
                       isEqual = 1;
                       break;
               }
               
               i++;
               j--;
       }


        
        if (isEqual == 0) {
                System.out.println("Yes");
        }
        else System.out.println("No");
    }
}



