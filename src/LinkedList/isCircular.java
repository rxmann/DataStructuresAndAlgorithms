package LinkedList;


import java.util.HashMap;
import java.util.Map;

public class isCircular {

    private static boolean isCircularList (Node head) {

        if (head == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCircularListII (Node head) {

        if (head == null) {
            return true;
        }

        Map<Node, Boolean> map = new HashMap<>();

        Node tempNode = head;

        while (tempNode != null) {
            tempNode = tempNode.next;
            if (map.containsKey(tempNode)) {
                return true;
            }
            map.put(tempNode, true);
        }
        return false;
    }


    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.insert(1);
        clist.insert(2);
        clist.insert(3);
        clist.insert(4);
        clist.insert(5);

        System.out.println("Circular Linked List");
        clist.displayCLL();
        System.out.println("\nIs circular ? " +  isCircularList (clist.head));

        CustomLinkedList list = new CustomLinkedList();
        list.insertAtTail(1);
        list.insertAtTail(2);
        list.insertAtTail(3);
        list.insertAtTail(4);
        list.insertAtTail(5);

        System.out.println("Singly Linked List");
        list.display();
        System.out.println("\nIs circular ? " + isCircularList (list.head));


    }
}
