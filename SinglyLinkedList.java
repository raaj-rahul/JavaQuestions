package demo;

public class SinglyLinkedList {
	    // Node class
	    class Node {
	        int data;
	        Node next;

	        Node(int data) {
	            this.data = data;
	            this.next = null;
	        }
	    }

	    Node head = null;

	    // Insert at beginning
	    public void insertAtBegin(int data) {
	        Node newNode = new Node(data);
	        newNode.next = head;
	        head = newNode;
	    }

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
	    }
	 // Insert at specific position
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
	        SinglyLinkedList list = new SinglyLinkedList();
	        list.insertAtBegin(10);
	        list.insertAtBegin(20);
	        list.insertAtBegin(30);
	        list.insertAtEnd(50);
	        list.insertAtEnd(40);
	        list.insertAtPosition(30, 1); 
	        list.insertAtPosition(60, 4); 
	        list.insertAtPosition(70, 10);

	        list.display();
	    }
	}

