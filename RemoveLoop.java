package demo;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class RemoveLoop {
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
    void createLoop(int pos) {
        if (pos == -1) return;
        Node loopNode = head;
        for (int i = 1; i < pos; i++) loopNode = loopNode.next;

        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = loopNode;
    }
    void detectAndRemoveLoop() {
        Node slow = head, fast = head;
        boolean loopExists = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) {
            System.out.println("No Loop Detected");
            return;
        }
        slow = head;
        if (slow == fast) {
            while (fast.next != slow)
                fast = fast.next;
        } else {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        fast.next = null;
        System.out.println("Loop Removed");
    }

    void display() {
        Node temp = head;
        HashSet<Node> visited = new HashSet<>();
        while (temp != null) {
            if (visited.contains(temp)) {
                System.out.print(" → (loop detected again at " + temp.data + ")");
                break;
            }
            System.out.print(temp.data + " ");
            visited.add(temp);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveLoop list = new RemoveLoop();
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        list.createLoop(3); 
        System.out.println("Before removing loop:");
        list.display();
        list.detectAndRemoveLoop();
        System.out.println("After removing loop:");
        list.display();
    }
}
