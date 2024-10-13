package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class FloydCycleDetection {
    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.head = new Node(1);
        clist.head.next = new Node(2);
        clist.head.next.next = new Node(3);
        clist.head.next.next.next = new Node(4);
        clist.head.next.next.next.next = new Node(5);
        clist.head.next.next.next.next.next = new Node(6);
        clist.head.next.next.next.next.next.next = new Node(7);
        clist.head.next.next.next.next.next.next.next = clist.head.next.next.next;

        System.out.println("Circular Linked List");
        clist.displayCLL();
        breakLoopCLL(clist.head);
        clist.displayCLL();
    }


    // floyd's detection of cycle
    // uses two pointers with different increment or speed
    private static Node getIntersectionLinkedList (Node head) {

        if (head == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            // System.out.println("Slow: " + slow.data + " : " + "Fast: " + fast.data);
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // System.out.println("Cycle at " + slow.data);
                return slow;
            }
        }

        return null;
    }


    // find the point of circular dependency
    private static Node findStartOfCircularList (Node head) {

        if (head == null) return head;

        Node intersection = getIntersectionLinkedList (head);

        if (intersection == null) return null;

        Node temp = head;

        while (temp != intersection) {
            temp = temp.next;
            intersection = intersection.next;
        }
        return temp;
    }

    // Break the loop
    private static void breakLoopCLL (Node head) {

        if (head == null ) return;

        Node cycleStart = findStartOfCircularList(head);
        Node temp = cycleStart;
        while (temp.next != cycleStart) {
            temp = temp.next;
        }

        temp.next = null;

    }
}
