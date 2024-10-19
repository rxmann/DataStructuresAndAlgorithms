package LinkedList;

public class merge2sortedList {
    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();

        list1.insertBulk(new int[]{1, 3, 5, 7, 9});
        list2.insertBulk(new int[]{2, 4, 5, 6, 12, 16, 18});

        System.out.println("Linked List 1");
        list1.display();
        System.out.println("Linked List 2");
        list2.display();


        CustomLinkedList resultList = new CustomLinkedList();
        resultList.head = mergeTwoSortedList (list1.head, list2.head);

        System.out.println("Merged list");
        resultList.display();

    }


    // merge two sorted list and return the head of the new merged list
    static Node mergeTwoSortedList(Node l1, Node l2) {

        if (l1 == null ) return l2;
        if (l2 == null) return l1;

        // Create a dummy node to simplify the merge process
        Node dummy = new Node(-1);
        Node current = dummy;

        // traverse
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;
                l1 = l1.next;
            }
            else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }


        if (l1 != null) {
            current.next = l1;
        }
        else {
            current.next = l2;
        }

        return dummy.next;

    }
}
