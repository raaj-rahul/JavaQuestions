package demo;
import java.util.*;
public class DoublyLinkedList {
			    // Node class
		    class Node {
		        int data;
		        Node prev;
		        Node next;

		        Node(int data) {
		            this.data = data;
		            this.prev=null;
		            this.next = null;
		        }
		    }

		    Node head = null;
		    // Insert at end
		    public void insertAtEnd(int data) {
		        Node newNode = new Node(data);
		        if (head == null) {
		            head = newNode;
		            return;
		        }
		        Node temp = head;
		        while (temp.next != null) {
		            temp = temp.next;
		        }
		        temp.next = newNode;
		        newNode.prev =temp;
		    }
		    // Insert at specific position (0-based index)
		    public void insertAtPosition(int data, int position) {
		        Node newNode = new Node(data);

		        if (position == 0) {
		            newNode.next = head;
		            head = newNode;
		            return;
		        }

		        Node temp = head;
		        for (int i = 0; i < position - 1 && temp != null; i++) {
		            temp = temp.next;
		        }

		        if (temp == null) {
		            System.out.println("Position out of bounds");
		            return;
		        }

		        newNode.next = temp.next;
		        temp.next = newNode;
		    }

		    // Display the list
		    public void display() {
		        if (head == null) {
		            System.out.println("List is empty");
		            return;
		        }
		        Node temp = head;
		        while (temp != null) {
		            System.out.print(temp.data + "->");
		            temp = temp.next;
		        }
		        System.out.println("null");
		    }

		    // Main method to test the code
		    public static void main(String[] args) {
		        DoublyLinkedList list = new DoublyLinkedList();
		        
		        list.insertAtEnd(50);
		        list.insertAtEnd(40);
		        list.insertAtPosition(30, 1); 
		        list.insertAtPosition(60, 4); 
		        list.insertAtPosition(70, 10);

		        list.display();
		    }
		}


