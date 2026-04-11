import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CollectionFrameworkSort {
    public static void main(String[] args) {

        // DEMO: using custom comparator for String
        var fruits = new ArrayList<String>();
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("grapes");
        fruits.add("watermelon");

        System.out.println("Base Fruits: " + fruits.toString());

        // 1. Sort in place (Ascending)
        Collections.sort(fruits);
        System.out.println("ASC Sorted Fruits: " + fruits);

        // 2. Sort in place (Descending)
        Collections.sort(fruits, Comparator.reverseOrder());
        System.out.println("DESC Sorted Fruits: " + fruits);

        // 3. if you want a new sorted list then
        // List<String> sortedFruitsAsc = fruits.stream().sorted().toList();

        var res = Comparator.comparing(s -> s.toString());
        System.out.println(res.toString());

    }
}
