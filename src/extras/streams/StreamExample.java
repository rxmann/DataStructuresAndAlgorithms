package streams;

import java.util.ArrayList;

public class StreamExample {
    public static void main(String[] args) {

        ArrayList<String> techStack = TechData.data;

        long start = System.currentTimeMillis();

        techStack.stream().forEach(System.out::println);
//        techStack.parallelStream().forEach(System.out::println);

        long end = System.currentTimeMillis();

        System.out.println("Sequential Time: " + (end - start) + "ms");
//        System.out.println("Parallel Time: " + (end - start) + "ms");

    }
}
