package LinkedList;

import static LinkedList.add2List.display;
import static LinkedList.merge2sortedList.mergeTwoSortedList;

public class mergeSort {
    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();
        list.insertBulk(new int[]{1, 2, 4, 3, 6, 5, 8, 7});
        System.out.println("Original list");
        display(list.head);
        list.head = mergeSortLL(list.head);
        System.out.println("Sorted list");
        display(list.head);
    }


    // linked list
    static Node mergeSortLL (Node head) {
        if (head == null || head.next == null ) {
            return head;
        }

        Node mid = findMidOfLinkedList(head);

        Node temp = mid.next;
        mid.next = null;

        Node left = mergeSortLL(head);
        Node right = mergeSortLL(temp);

        Node res = mergeTwoSortedList(left , right);

        return res;

    }

    private static Node findMidOfLinkedList(Node head) {

        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
