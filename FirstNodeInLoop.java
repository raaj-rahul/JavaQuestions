package demo;
public class FirstNodeInLoop {
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
    void createLoop(int pos) {
        if (pos == -1) return;
        Node loopNode = head;
        for (int i = 1; i < pos; i++)
            loopNode = loopNode.next;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = loopNode;
    }
    Node findFirstNodeInLoop() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {   
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; 
            }
        }

        return null; 
    }

    public static void main(String[] args) {
        FirstNodeInLoop list = new FirstNodeInLoop();
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');

        list.createLoop(3); 

        Node loopStart = list.findFirstNodeInLoop();
        if (loopStart != null)
            System.out.println("Loop starts at node: " + loopStart.data);
        else
            System.out.println("No loop in the list");
    }
}
