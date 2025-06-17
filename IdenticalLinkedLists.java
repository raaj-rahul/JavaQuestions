package demo;
public class IdenticalLinkedLists {
import java.util.*;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
    Node head;

    void insert(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    static boolean areIdentical(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data)
                return false;
            head1 = head1.next;
            head2 = head2.next;
        }
        return (head1 == null && head2 == null);
    }

    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IdenticalLinkedLists list1 = new IdenticalLinkedLists();
        IdenticalLinkedLists list2 = new IdenticalLinkedLists();
        list1.insert('a');
        list1.insert('b');
        list1.insert('c');
        list2.insert('a');
        list2.insert('b');
        list2.insert('c');

        System.out.print("List 1: ");
        display(list1.head);

        System.out.print("List 2: ");
        display(list2.head);

        if (areIdentical(list1.head, list2.head))
            System.out.println("Lists are Identical");
        else
            System.out.println("Lists are NOT Identical");
    }
}

