package DSA2.LinkedList;

import java.util.HashMap;
import java.util.LinkedList;

public class DeepCopy {

    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        one.next = two;
        two.next = three;
        three.next = null;

        one.random = three;
        two.random = one;
        three.random = two;
        LinkedList<Node> list = new LinkedList<>();
        list.add(one);
        list.add(two);
        list.add(three);

        for(Node node : list){
            System.out.println(node.value);
        }
    }

}

class Node {
    int value;
    Node next;
    Node random;

    public Node(int value){
        this.value = value;
    }
}