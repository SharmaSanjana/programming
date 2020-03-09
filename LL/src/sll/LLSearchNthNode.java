package sll;

public class LLSearchNthNode {
	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	private void printLL(){
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.print("null");
	}
	private void push(int d) {
		Node newNode = new Node(d);
		newNode.next=head;
		head = newNode;
	}
	private int getNthNode(int i) {
		Node temp = head;
		for(int j=0;j<=i;j++) {
			temp = temp.next;
		}
		return i;
		
	}
	public static void main(String[] args) {
		LLSearchNthNode ll = new LLSearchNthNode();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printLL();

	}

}
