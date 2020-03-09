package sll;

public class LLFindLength {
	class Node{
		int data; Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	private void printLL() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	private void push(int d) {
		Node newNode = new Node(d);
		newNode.next = head;
		head = newNode;
	}
	private int findLengthIterative() {
		Node temp = head; int count=0;
		while(temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;
	}
	
	private int fingLengthRecursive() {
		return getCountRec(head);
	}
	
	private int getCountRec(Node node) {
		if(node==null) return 0;
		return 1 + getCountRec(node.next);
	}
	public static void main(String[] args) {
		LLFindLength ll = new LLFindLength();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printLL();
		int lengthItr = ll.findLengthIterative();
		System.out.println("Itr length is "+lengthItr);
		int lengthRec = ll.fingLengthRecursive();
		System.out.println("Rec length is "+lengthRec);
		
	}
	
}
