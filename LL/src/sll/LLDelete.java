package sll;

public class LLDelete {

	class Node{
		int data;
		Node next;
		Node(int d){
			data = d;
			next = null;
		}
	}
	Node head;
	private void deleteLL() {
		head = null;
		return;
	}
	public static void main(String[] args) {
		LLDelete ll = new LLDelete();
		ll.push(3);ll.push(2);ll.push(1);
		ll.printLL();
		ll.deleteLL();
		ll.printLL();
	}
	private void printLL() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+"->");
			temp = temp.next;
		}
		System.out.println("null");
	}
	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next = head;
		head = newNode;
		
	}

}
