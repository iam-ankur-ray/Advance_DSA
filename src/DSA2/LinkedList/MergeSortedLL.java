package DSA2.LinkedList;

import java.util.LinkedList;

/**
 * Find the mid with slow and fast pointer
 * Break the LL into two at mid
 * Call merged sort separately
 * Merge two sorted LL
 */
public class MergeSortedLL {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node four = new Node(4);
        Node three = new Node(3);
        Node six = new Node(6);

        one.next = three;
        three.next = four;
        four.next = six;
        six.next = null;

        Node mid = findMiddleNode(one);
        Node h1 = one;
        Node h2 = mid.next;
        mid.next = null;

        Node mergedNode = mergeNodes(h1,h2);
        while(mergedNode != null){
            System.out.println(mergedNode.value);
            mergedNode = mergedNode.next;
        }




    }

    public static Node findMiddleNode(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node mergeNodes(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Node head = null;

        if(h1.value < h2.value){
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }
        Node current = head;

        while (h1 != null && h2 != null){
            if(h1.value < h2.value){
                current.next = h1;
                h1 = h1.next;
            } else {
                current.next = h2;
                h2 = h2.next;
            }

            current = current.next;
        }

        if(h1 == null){
            current.next = h2;
        } else {
            current.next = h1;
        }

        return head;
    }

}
