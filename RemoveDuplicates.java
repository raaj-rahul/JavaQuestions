package demo;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicates {
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
    void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next; // move forward only if no duplicate
            }
        }
    }
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveDuplicates list = new RemoveDuplicates();
        list.insert(10);
        list.insert(20);
        list.insert(20);
        list.insert(30);
        list.insert(30);
        list.insert(40);

        System.out.print("Original List: ");
        list.display();

        list.removeDuplicates();

        System.out.print("After Removing Duplicates: ");
        list.display();
    }
}

