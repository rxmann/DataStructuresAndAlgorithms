package LinkedList;

public class add2List {

    public static void main(String[] args) {
        CustomLinkedList list1 = new CustomLinkedList();
        CustomLinkedList list2 = new CustomLinkedList();
        list1.insertBulk(new int[] {1, 2, 9});
        list2.insertBulk(new int[] {5, 1});

        Node ansHead = addTwoList(list1.head, list2.head);
        display(ansHead);


    }

    private static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }


    private static Node addTwoList(Node head1, Node head2) {

        head1 = reverseList(head1);
        head2 = reverseList(head2);
        display(head1);
        display(head2);

        Node tempHead = new Node(99);
        Node node = tempHead;

        int sum = 0, carry = 0;

        while (head1 != null || head2 != null) {
            sum = carry;

            // Add data from the first list if available
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            // Add data from the second list if available
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }


            tempHead.next = new Node(sum%10);
            tempHead = tempHead.next;

            carry = sum / 10;

        }
        if (carry > 0) {
            tempHead.next = new Node(carry);
        }

        return reverseList(node.next);
    }


    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
