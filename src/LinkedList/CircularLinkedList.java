package LinkedList;

import java.util.HashMap;
import java.util.Map;

// Custom Linked List class
public class CircularLinkedList {


    Node head;

    // Insert at the head
    public void insert (int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            return;
        }

        Node tempNode = head;
        while (tempNode.next != head) {
            tempNode = tempNode.next;
        }
        tempNode.next = newNode;
        newNode.next = head;

    }


    // Deletion of a node by value
    public void deleteNode(int idx) {
        if (head == null) return;

        Node temp = head;
        int count = 1;
        while (count < idx-1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) return;

        Node deleteNode = temp.next;
        temp.next = temp.next.next;
        deleteNode.next = null;

    }

    // Display the list
    public void displayCLL () {

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

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);



        System.out.println("Linked List:");
        list.displayCLL();

        list.deleteNode(4);

        System.out.println("\nAfter Deleting 4th:");
        list.displayCLL();

    }

    public void insertBulk(int[] arr) {
        for(int x: arr) {
            this.insert(x);
        }
    }
}