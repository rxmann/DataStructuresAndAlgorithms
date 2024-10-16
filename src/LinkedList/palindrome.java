package LinkedList;

public class palindrome {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertBulk(new int[]{1,2,3,4,5,4,3,2,1});
        System.out.println("Circular List: ");
        list.display();
        boolean ans = checkPalindromLL (list.head);
        System.out.println(ans);
    }

    private static boolean checkPalindromLL(Node head) {
        // Empty or single-node list is a palindrome
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list using fast and slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the linked list
        Node prev = null;
        Node curr = slow;
        while (curr != null) {
            Node temp = curr.next;
            curr.next= prev;
            prev = curr;
            curr = temp;
        }

        // Step 3: Compare the first half with the reversed second half
        Node h1 = head;
        Node h2 = prev;

        while (h2 != null) {
            if (h1.data != h2.data) return false;
            h1 = h1.next;
            h2= h2.next;
        }
        return true;
    }

}
