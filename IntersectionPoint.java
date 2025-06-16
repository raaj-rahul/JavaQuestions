package demo;
import java.util.*;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class IntersectionPoint {
    static int getLength(Node head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
    static Node getIntersection(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);
        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }
        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) return head1;  
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String[] args) {
        Node common = new Node('x');
        common.next = new Node('y');
        common.next.next = new Node('z');
        Node head1 = new Node('a');
        head1.next = new Node('b');
        head1.next.next = new Node('c');
        head1.next.next.next = common;
        Node head2 = new Node('p');
        head2.next = new Node('q');
        head2.next.next = common;
        Node intersect = getIntersection(head1, head2);

        if (intersect != null)
            System.out.println("Intersection at node with data: " + intersect.data);
        else
            System.out.println("No intersection found.");
    }
}
