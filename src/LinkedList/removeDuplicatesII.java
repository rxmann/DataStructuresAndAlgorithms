package LinkedList;

// Remove duplicates from sorted linked list

public class removeDuplicatesII {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
//        list.insertAtHead(5);
        list.insertAtHead(5);
        list.insertAtHead(4);
        list.insertAtHead(4);
        list.insertAtHead(3);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);
        list.insertAtHead(1);

        System.out.println("Original linked list");
        list.display();

        list.head = removeDuplicatesFromSortedLL (list.head);

        System.out.println("Duplicates removed linked list");
        list.display();


    }

    private static Node removeDuplicatesFromSortedLL(Node head) {

        Node tempHead = new Node(0);

        Node temp = head;
        // last non repeating node
        Node prev = tempHead;

        while (temp != null && temp.next != null ) {

            if (temp.data == temp.next.data) {
                while (temp.data == temp.next.data ) {
                    temp = temp.next;
                }
                prev.next = temp.next;
            }
            else {
                prev = temp;
            }

            temp = temp.next;
        }

        return tempHead.next;
    }


}
