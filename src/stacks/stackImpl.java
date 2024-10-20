package stacks;

import java.util.Stack;

public class stackImpl {
    public static void main(String[] args) {
        Stack<Integer> rollno = new Stack<>();

        // insert
        rollno.push(1);
        rollno.push(2);
        rollno.push(3);
        rollno.push(4);
        rollno.push(5);
        rollno.push(6);

        // read: peek/pop
        System.out.println("Peek Stack: " + rollno.peek());

        // delete
        System.out.println("Pop Stack: " + rollno.pop());

        //
        System.out.println("Is  stack empty? " + rollno.empty());
        System.out.println("Search for 3 in stack: " + rollno.search(3)); // returns index+1

        System.out.println("Stack data");
        System.out.println(rollno);


    }
}
