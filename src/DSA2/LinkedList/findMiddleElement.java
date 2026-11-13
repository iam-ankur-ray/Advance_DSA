package DSA2.LinkedList;


public class findMiddleElement {
    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        first.next = second;
        second.next = third;
        third.next = null;

        Node ans = findMiddle(first);
        System.out.println(ans.value);
    }

    public static Node findMiddle(Node head){
        if(head == null){
            return null;
        }

        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
