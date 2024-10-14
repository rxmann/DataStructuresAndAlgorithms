package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class breakCircularListTo2 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insertBulk(new int[]{1,2,3,4,5,6,7});
        System.out.println("Circular Linked list");
        list.displayCLL();
        Node[] answer = breakListToHalf(list.head);
        displayCLL (answer[0]);
        displayCLL (answer[1]);
    }

    private static void displayCLL(Node head) {
        if (head == null) return;
        Map<Node, Boolean> visited = new HashMap<>();
        Node current = head;
        while (!visited.containsKey(current) || current != null) {
            if (visited.containsKey(current)) {
                System.out.println(current.data);
                break;
            }
            if (current == null) {
                System.out.println("null");
                break;
            }
            System.out.print(current.data + " -> ");
            visited.put(current, true);
            current = current.next;
        }
    }

    private static Node[] breakListToHalf(Node head) {

        int count = 1;
        Node curr = head.next;
        // count number of nodes
        while (curr!=head) {
            count++;
            curr = curr.next;
        }

        // divide and iterate till the index and point back to head
        count  = count / 2;
        curr = head;
        while (count > 0 ) {
            curr = curr.next;
            count--;
        }

        Node temp =  curr.next;

        curr.next = head;

        Node tep = temp;
        while (tep.next != head) {
            tep = tep.next;
        }
        tep.next = temp;
        return new Node[]{head, temp};
    }
}
