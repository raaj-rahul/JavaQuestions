package demo;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class NthFromEnd {
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

    void findNthFromEnd(int n) {
        Node first = head;
        Node second = head;
        for (int i = 0; i < n; i++) {
            if (first == null) {
                System.out.println("List is shorter than " + n + " nodes.");
                return;
            }
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println(n + "th node from the end is: " + second.data);
    }

    public static void main(String[] args) {
        NthFromEnd list = new NthFromEnd();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.findNthFromEnd(2);  
    }
}
