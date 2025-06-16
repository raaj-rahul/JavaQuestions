package demo;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class MergeSortedLists {
    Node head;

    void insert(int data) {
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
    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }
        if (head1 != null) current.next = head1;
        if (head2 != null) current.next = head2;

        return dummy.next;
    }
    static void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeSortedLists list1 = new MergeSortedLists();
        MergeSortedLists list2 = new MergeSortedLists();

        list1.insert(10);
        list1.insert(20);
        list1.insert(30);

        list2.insert(15);
        list2.insert(25);
        list2.insert(35);

        System.out.print("List 1: ");
        display(list1.head);

        System.out.print("List 2: ");
        display(list2.head);

        Node mergedHead = merge(list1.head, list2.head);
        System.out.print("Merged List: ");
        display(mergedHead);
    }
}

