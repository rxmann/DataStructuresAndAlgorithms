package LinkedList;


import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListII {

    public static void main(String[] args) {
        // Create the nodes
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode head = node1;

        // Set the next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Set the random pointers
        node1.random = node3;
        node2.random = node5;
        node3.random = node2;
        node4.random = node1;
        node5.random = node4;

        // Original
        printList(node1);

        System.out.println("----------------------------------");
        ListNode newHead = cloneList(head);

        // cloned
        printList(newHead);
    }

    private static ListNode cloneList(ListNode head) {

        // clone linked list with next pointer only first
        ListNode cloneHead = new ListNode(2);
        ListNode clone = cloneHead;

        ListNode temp = head;
        while (temp != null) {
            clone.next = new ListNode(temp.data);
            clone = clone.next;
            temp = temp.next;
        }

        // create a map to store the random of every nodes
        Map<ListNode, ListNode> map = new HashMap<>();
        temp = head;
        clone = cloneHead.next;
        while (temp != null && clone != null) {
            map.put(temp, clone);
            clone = clone.next;
            temp = temp.next;
        }

        // arrange the random pointers
        temp = head;
        clone = cloneHead.next;

        while (temp != null && clone != null) {
            clone.random = map.get(temp.random);
            clone = clone.next;
            temp = temp.next;
        }

        return cloneHead.next;
    }


    // Helper method to print the linked list with random pointers
    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print("Node: " + current.data);
            if (current.random != null) {
                System.out.print(", Random: " + current.random.data);
            } else {
                System.out.print(", Random: null");
            }
            System.out.println();
            current = current.next;
        }
    }

}
