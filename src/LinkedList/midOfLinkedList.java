package LinkedList;

public class midOfLinkedList {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAtHead(12);
        list.insertAtHead(10);
        list.insertAtHead(8);
        list.insertAtHead(6);
        list.insertAtHead(4);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.display();

        int mid = getMidFromLL (list);
        System.out.println("Mid: " + mid);
    }

    // Using Two-Pointers approach
    static int getMidFromLL (CustomLinkedList list) {

        if (list.head == null) {
            return -1;
        }

        Node slow = list.head;
        Node fast = list.head;

        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    // Brute Force O(2N)
    public static int getMidElementLL (CustomLinkedList list) {

        Node temp = list.head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int mid = length / 2;
        length = 0;
        temp = list.head;
        while (length < mid) {
            temp = temp.next;
            length++;
        }

        return temp.data;
    }


}
