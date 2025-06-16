package demo;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class DetectRemoveLoop {
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
    boolean detectAndRemoveLoop() {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                removeLoop(slow);
                return true;
            }
        }

        return false;
    }
    void removeLoop(Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = null;
    }
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DetectRemoveLoop list = new DetectRemoveLoop();
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        list.head.next.next.next.next.next = list.head.next.next;
        if (list.detectAndRemoveLoop())
            System.out.println("Loop was detected and removed.");
        else
            System.out.println("No loop found.");
        System.out.print("Linked List after loop removal: ");
        list.display();
    }
}
