package LinkedList;

import java.sql.SQLOutput;

public class reverseLL {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAtTail(2);
        list.insertAtTail(4);
        list.insertAtTail(6);
        list.insertAtTail(8);
        list.insertAtTail(10);
        System.out.print("Linked List Before: ");
        list.display();

        // reverse
        reverseLinkedList (list, null, list.head);

        System.out.print("Linked List After: ");
        list.display();
    }


    // BRUTE FORCE APPROACH
    private static void reverseLinkedListBF(CustomLinkedList list) {
        Node prevNode = null;
        Node currentNode = list.head;

        while (currentNode != null) {
            Node tempNode = currentNode.next;
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = tempNode;
        }

        list.head = prevNode;

    }

    // RECURSIVE APPROACH
    private static void reverseLinkedList (CustomLinkedList list, Node prev, Node current) {

        if (current == null) {
            list.head = prev;
            return;
        }

        // recursive call
        reverseLinkedList(list, current, current.next);
        current.next = prev;

    }
}
