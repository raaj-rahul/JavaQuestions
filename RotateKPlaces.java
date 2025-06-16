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

public class RotateKPlaces {
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

      int getLength() {
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

      void rotateRight(int k) {
        if (head == null || k == 0)
            return;

        int length = getLength();
        k = k % length;
        if (k == 0)
            return;
        Node oldTail = head;
        int count = 1;
        while (count < length) {
            oldTail = oldTail.next;
            count++;
        }
        oldTail.next = head;
        int stepsToNewHead = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++)
            newTail = newTail.next;

        head = newTail.next;
        newTail.next = null;
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
        RotateKPlaces list = new RotateKPlaces();
        list.insert('a');
        list.insert('b');
        list.insert('c');
        list.insert('d');
        list.insert('e');
        int k = 2;
        System.out.print("Original List: ");
        list.display();
        list.rotateRight(k);
        System.out.print("List after rotating " + k + " places: ");
        list.display();
    }
}
