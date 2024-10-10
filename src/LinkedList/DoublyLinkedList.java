package LinkedList;

public class DoublyLinkedList {


    Node head;
    Node tail;

    // Node
    class Node {

        int data;
        Node next;
        Node prev;

        Node (int value) {
            this.data = value;
            this.prev = null;
            this.next = null;
        }
    }

    // insert first
    void insertHead (int value) {
        Node newNode = new Node(value);
        if (head != null) {
            head.prev = newNode;
            newNode.next = head;
        }
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    // insert last
    void insertTail (int value) {
        Node newNode = new Node(value);
        if (head == null && tail == null) {
            head= newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // insert at index+1
    private void insertAtIndex(int idx, int value) {
        if (idx <= 1) {
            insertHead(value);
            return;
        }
        // find the prev and next node and adjust the references
        Node tempNode = head;
        int count = 1;
        while (count < idx-1 && tempNode.next != null) {
            tempNode = tempNode.next;
            count++;
        }

        // index out of bounds or at last
        if (tempNode.next == null) {
            insertTail(value);
            return;
        }

        // insert after tempNode and adjust
        Node newNode = new Node(value);
        newNode.next = tempNode.next;
        newNode.prev = tempNode;
        newNode.next.prev = newNode;
        tempNode.next = newNode;

    }

    // Delete at index
    void deleteAtIndex (int idx) {

        // if empty list
        if (head == null || idx <= 0) return;
        // if head to remove
        if (idx == 1) {
            Node temp = head;
            if (head.next == null) { // Only one node
                head = null;
                tail = null;
            } else {
                head = head.next;   // Move head to next node
                head.prev = null;   // Clear the prev reference of the new head
            }
            temp.next = null;
            System.out.println("Deleted head!");
            return;
        }

        // for other nodes between head and tail
        Node tempNode = head;
        int count = 1;

        while (tempNode != null && count < idx) {
            tempNode = tempNode.next;
            count++;
        }

        // If tempNode is null, it means index is out of bounds
        if (tempNode == null ) return;

        // Adjust next and prev pointers of surrounding nodes
        if (tempNode.next != null) {
            tempNode.next.prev = tempNode.prev; // Adjust prev of next node
        } else {
            tail = tempNode.prev; // Update tail if last node is deleted
        }

        if (tempNode.prev != null) {
            tempNode.prev.next = tempNode.next; // Adjust next of prev node
        }

        // Nullify tempNode pointers (optional)
        tempNode.prev = null;
        tempNode.next = null;

    }


    // print the linked list elements
    void displayLL () {
        if (head != null && tail != null) {
            System.out.println("HEAD: " + (head.data) + " TAIL: " + tail.data);
        }
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }




    // *******************************************************************************

    public static void main(String[] args) {

        DoublyLinkedList dlist = new DoublyLinkedList();

        // try to delete at empty
        dlist.deleteAtIndex(1);

        // insert first and last
        dlist.insertTail(24);
        dlist.insertHead(12);
        dlist.insertHead(10);

        // insert at position; index
        dlist.insertAtIndex(3, 99);

        // delete
        dlist.deleteAtIndex(2);


        // print
        dlist.displayLL();


    }



}
