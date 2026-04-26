import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FuncProgram {
    public static void main(String[] args) {

        int[] grades = { 12, 15, 13, 11, 10, 8 };
        Arrays.stream(grades).sorted().forEach(g -> System.out.print(g + "\t"));
        System.out.println("\n");

        List<String> words = List.of("apple", "banana", "kiwi", "strawberry", "fig");

        System.out.println("Original words list: " + words.toString());
        System.out.println(transformStringLengths(words));
    }

    public static List<Integer> transformStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
