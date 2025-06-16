package demo;
class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class DeleteWithoutHead {
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
    void deleteNode(Node nodeToDelete) {
        if (nodeToDelete == null || nodeToDelete.next == null) {
            System.out.println("Cannot delete the last node or null node using this method.");
            return;
        }
        nodeToDelete.data = nodeToDelete.next.data;
        nodeToDelete.next = nodeToDelete.next.next;
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
        DeleteWithoutHead list = new DeleteWithoutHead();
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        System.out.print("Original List: ");
        list.display();
        Node nodeToDelete = list.head.next.next; 
        list.deleteNode(nodeToDelete);
        System.out.print("List after deleting node 'c': ");
        list.display();
    }
}
