package strings;

import java.util.*;

public class Anagrams {

    static boolean isAnagram(String a, String b) {
        
        if (a.length() != b.length()) {
                return false;
        }
            
          
        // lower case both strings
        a = a.toLowerCase();  
        b = b.toLowerCase();  
            
            
        // Complete the function
        Map<Character, Integer> map = new HashMap<>(0);
        for (int i=0; i< a.length(); i++) {
                Character ch = a.charAt(i);
               if (map.containsKey(ch)) {
                       int count = map.get(ch);
                       map.put(ch, ++count);
               }
               else {
                        map.put(ch, 1);
               }
        }
        for (int i=0; i< b.length(); i++) {
              char ch = b.charAt(i);
              if (!map.containsKey(ch)) {
                      return false;
              }  
                
                int count = map.get(ch);
                
              if (count == 0) {
                      return false;
              }
              else {
                      map.put(ch, --count);
              }
        }
        return true;
    }

  public static void main(String[] args) {

        boolean ret = isAnagram("people", "people");
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}