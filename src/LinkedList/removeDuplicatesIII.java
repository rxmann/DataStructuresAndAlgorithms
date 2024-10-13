package LinkedList;


// remove duplicates form unsorted linked list
//

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class removeDuplicatesIII {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertBulk(new int[]{19, 45, 32, 19, 45, 19, 19});

        System.out.println("Linked List");
        list.display();
        removeDuplicatesUnsortedList(list.head);
        System.out.println("Duplicates removed Linked List");
        list.display();
    }

    // remove duplicates : keep all elements
    private static void removeDuplicatesUnsortedList (Node head) {

        Set<Integer> set = new HashSet<>();

        Node curr = head;
        Node tempNode = null;

        while (curr != null) {
            if (set.contains(curr.data)) {
                tempNode.next = curr.next;
            }
            else {
                set.add(curr.data);
                tempNode = curr;
            }
            curr = curr.next;
        }

    }
}
