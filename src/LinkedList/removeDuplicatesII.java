package LinkedList;

// Remove duplicates from sorted linked list
// new list should not contain the repeating elements
// Input: 1->1->2->3->3->4->5->5->6->NULL
// output: 2->4->6->null

public class removeDuplicatesII {

    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
//        list.insertAtHead(5);
        list.insertBulk(new int[]{1,1});

        System.out.println("Original linked list");
        list.display();

        list.head = removeDuplicatesFromSortedLL (list.head);

        System.out.println("Duplicates removed linked list");
        list.display();


    }

    private static Node removeDuplicatesFromSortedLL(Node head) {

        Node tempHead = new Node(0);
        tempHead.next = head;

        Node temp = head;
        // last non repeating node
        Node prev = tempHead;

        while (temp != null && temp.next != null ) {

            if (temp.data == temp.next.data) {
                while (temp.next != null && temp.data == temp.next.data ) {
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
