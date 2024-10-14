package LinkedList;

public class sort012 {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        list.insertBulk(new int[]{2,2,2,1,1,2,0,2,0,1,1,0});
        System.out.println("Linked list: ");
        list.display();
        list.head = sort012LL(list.head);
        System.out.println("Linked list sorted 012 ");
        list.display();

    }

    private static Node sort012LL (Node head) {

        if (head == null || head.next == null) return head;
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node tempNode=  head;
        // count number of occurences
        while (tempNode != null) {
            int currVal = tempNode.data;
            if (currVal == 0) {
                zeroCount++;
            }
            else if (currVal == 1) {
                oneCount++;
            }
            else {
                twoCount++;
            }
            tempNode = tempNode.next;
        }
        // System.out.println(zeroCount + " : " + oneCount + " : " + twoCount);
        // make new List
        Node tempHead = head;
        while (zeroCount > 0) {
            tempHead.data = 0;
            tempHead = tempHead.next;
            zeroCount--;
        }
        while (oneCount > 0) {
            tempHead.data = 1;
            tempHead = tempHead.next;
            oneCount--;
        }
        while (twoCount > 0) {
            tempHead.data = 2;
            tempHead = tempHead.next;
            twoCount--;
        }

        return head.next;
    }

}
