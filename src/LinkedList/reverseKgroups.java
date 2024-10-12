package LinkedList;

public class reverseKgroups {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertAtHead(9);
        list.insertAtHead(8);
        list.insertAtHead(7);
        list.insertAtHead(6);
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.display();

        list.head = reverseKGroup (list.head, 3);                                           
        System.out.println("After reversal in K groups: " );
        list.display();
    }

    // Function to reverse k nodes in the linked list
    public static Node reverseKGroup(Node head, int k) {

        // if empty list or only one node
        if (head == null || k == 1) {
            // System.out.println("Head: " + head.data);
            return head;
        }


        // check range
        int count = 0;
        Node tempNode = head;
        while (count < k && tempNode != null ) {
            tempNode = tempNode. next;
            count++;
        }

        // return current head if less than k size left to reverse
        if (count < k) return head;


        // reverse k size
        tempNode = null;
        Node prev = null;
        Node current = head;
        for (int i=0; i<k; i++) {
            tempNode = current.next;
            current.next = prev;
            prev = current;
            current = tempNode;
        }
        
        if (tempNode != null) {
            head.next = reverseKGroup(tempNode, k);
        }
        System.out.println("Prev: " + prev.data);
        return prev;
    }
}
