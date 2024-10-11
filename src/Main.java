import LinkedList.CustomLinkedList;

import java.util.List;

public class Main {


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);

        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node  = node.next;
        }
        System.out.println("null");

        head = reverseList(head);
        node = head;
        while (node != null) {
            System.out.print(node.val + "->");
            node  = node.next;
        }
        System.out.println("null");
    }

    public static ListNode reverseList(ListNode head) {
        return reverseRecursion(head);
    }

    static ListNode reverseRecursion(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = reverseRecursion(head.next);

        head.next.next = head;
        head.next = null;

        return node;
    }
}