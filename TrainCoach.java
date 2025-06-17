package demo;
import java.util.*;
class Stack{
	String[] a = new String[5];
	Set<String> set = new HashSet<>();
	int top = -1;
	public void push(String data) {
		if(top == a.length-1) {
			System.out.println("overflow");
		}else if(set.contains(data)) {
			System.out.println("Duplicate coach");
		}else if(top >=0 && isF(a[top]) && isP(data)) {
			System.out.println("passenger cannot be placed");
		}else {
			top++;
			a[top] = data;
			set.add(data);
			System.out.println("pushed element: " + a[top]);
		}
	}
	
	public Boolean isF(String data) {
		return data.startsWith("F");
	}
	public Boolean isP(String data) {
		return data.startsWith("P");
	}
	public void pop() {
		if(top == -1) {
			System.out.println("underflow");
		}else {
			System.out.println("popped element: " + a[top]);
			set.remove(a[top]);
			top--;
		}
	}
	public void peek() {
		if(top == -1) {
			System.out.println("empty");
		}else {
			System.out.println(a[top]);
		}
	}
	public void display() {
		if(top == -1) {
			System.out.println("empty");
		}else {
			for(int i = top; i>=0; i--) {
				System.out.println(a[i]);
			}
		}
	}
}
public class TrainCoach{
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("AC01");
		stack.push("PC02");
		stack.push("PC04");
		stack.push("FC01");
		stack.push("PC01");
		stack.pop();
		stack.peek();
		stack.display();
	}
}
