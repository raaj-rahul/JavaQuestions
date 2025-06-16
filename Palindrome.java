
import java.util.Stack;

class Node {
    char data;
    Node next;
    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeLinkedList {
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
    boolean isPalindrome() {
        Stack<Character> stack = new Stack<>();
        Node temp = head;
     while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.data != stack.pop()) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();

        list.insert('r');
        list.insert('a');
        list.insert('c');
        list.insert('e');
        list.insert('c');
        list.insert('a');
        list.insert('r');

        if (list.isPalindrome())
            System.out.println("The linked list is a palindrome.");
        else
            System.out.println("The linked list is not a palindrome.");
    }
}
