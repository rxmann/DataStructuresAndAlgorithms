package LinkedList;



// Custom Linked List class
public class CustomLinkedList {

    public Node head;

    // Insert at the head
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the tail
    public void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Insert at the middle (after a specific position)
    public void insertAtMiddle(int data, int position) {
        if (position == 0) {
            insertAtHead(data);
            return;
        }

        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < position - 1; i++) {
            if (current == null) {
                System.out.println("Position out of bounds");
                return;
            }
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Deletion of a node by value
    public void deleteNode(int data) {
        if (head == null) return;

        // If head needs to be deleted
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Node not found");
            return;
        }

        current.next = current.next.next;
    }

    // Display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);

        list.insertAtTail(5);
        list.insertAtTail(6);

        list.insertAtMiddle(4, 3);  // Insert 4 after position 3

        System.out.println("Linked List:");
        list.display();

        list.deleteNode(3);
        System.out.println("After Deleting 3:");
        list.display();
    }

    public void insertBulk(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            insertAtTail(arr[i]);
        }
    }
}
